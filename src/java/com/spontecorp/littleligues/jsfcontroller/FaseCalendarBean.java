/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spontecorp.littleligues.jsfcontroller;

import com.spontecorp.littleligues.jpacontroller.extentions.*;
import com.spontecorp.littleligues.model.liga.Categoria;
import com.spontecorp.littleligues.model.liga.Liga;
import com.spontecorp.littleligues.model.torneo.*;
import com.spontecorp.littleligues.utils.LittleLiguesUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zuleidyb
 */
@ManagedBean(name = "faseCalendarBean")
@ViewScoped
public final class FaseCalendarBean implements Serializable {

    private int idLiga;
    private int idCategoria;
    private int idFase;
    private int idGrupo;
    private List<Partido> partidoList = new ArrayList<Partido>();
    private int totalPartidoList;
    private Grupo grupoActual;
    private Jornada jornadaActual;
    private boolean hayPartidos = false;

    public FaseCalendarBean() {

    }

    public List<Categoria> getClassification() {
        FacesContext context = FacesContext.getCurrentInstance();
        idLiga = context.getExternalContext().getRequestParameterMap().get("idLiga") != null ? Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idLiga")) : -1;
        idFase = context.getExternalContext().getRequestParameterMap().get("idFase") != null ? Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idFase")) : -1;

        LigaJpaControllerExt ligaJpaController = new LigaJpaControllerExt(LittleLiguesUtils.getEmf());
        FaseJpaControllerExt faseJpaController = new FaseJpaControllerExt(LittleLiguesUtils.getEmf());

        Liga liga = ligaJpaController.findLiga(idLiga);
        Fase fase = faseJpaController.findFase(idFase);
        
        CategoriaJpaControllerExt categoriaJpaController = new CategoriaJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Categoria> allCategories = categoriaJpaController.findListCategoria();
        List<Categoria> allCategories2 = new ArrayList<Categoria>();

        for (Categoria categoriaActual : allCategories) {
            Categoria cat = calcClassification(categoriaActual, fase, liga);
            allCategories2.add(cat);
        }

        return allCategories2;
    }

    public Categoria calcClassification(Categoria categoria, Fase fase, Liga liga) {

        CategoriaJpaControllerExt categoriaJpaController = new CategoriaJpaControllerExt(LittleLiguesUtils.getEmf());
        GrupoJpaControllerExt grupoJpaController = new GrupoJpaControllerExt(LittleLiguesUtils.getEmf());
        LlaveJpaControllerExt llaveJpaController = new LlaveJpaControllerExt(LittleLiguesUtils.getEmf());
        JornadaJpaControllerExt jornadaJpaController = new JornadaJpaControllerExt(LittleLiguesUtils.getEmf());

        //Lista de Categorias
        List<Categoria> allCategories = categoriaJpaController.findListCategoria();
        List<Categoria> allCategories2 = new ArrayList<Categoria>();
        List<Grupo> allGrupos = grupoJpaController.findGruposOnFase(fase);
        List<Llave> allLlaves = llaveJpaController.findLlavesOnFase(fase);

        Categoria categoriaActual = categoria;
        boolean hayPartidos = false;

        List<Grupo> allGrupos2 = new ArrayList<Grupo>();
        List<Llave> allLlaves2 = new ArrayList<Llave>();

        if (allGrupos.size() > 0) {
            for (Grupo grupoActual : allGrupos) {
                List<Jornada> allJornadas = grupoActual.getJornadaList();
                List<Jornada> allJornadas2 = new ArrayList<Jornada>();
                List<Partido> partidoList = new ArrayList<Partido>();

                grupoActual.setTotalJornadas(allJornadas.size());

                if (allJornadas != null) {

                    jornadaActual = jornadaJpaController.findCurrentJornada(grupoActual);
                    if (jornadaActual == null) {
                        jornadaActual = grupoActual.getJornadaList().get(0);
                        jornadaActual.setIsCurrent(1);
                    }

                    List<Clasifica> tableClasif = calcularClasificacion(categoriaActual, jornadaActual, grupoActual, liga);

                    //Se busca el Calendario por cada Jornada
                    partidoList = getListaPartidosJornadas(categoriaActual, jornadaActual);
                    jornadaActual.setPartidoJornada(partidoList);

                    if (partidoList.size() > 0) {
                        hayPartidos = true;
                    }

                    if (tableClasif.size() > 0) {
                        jornadaActual.setClasificaFase(tableClasif);
                    }

                    if (partidoList.size() > 0) {
                        allJornadas2.add(jornadaActual);
                    }

                    if (allJornadas2.size() > 0) {
                        grupoActual.setAllJornadas(allJornadas2);
                        allGrupos2.add(grupoActual);
                    }
                }
            }

            categoriaActual.setAllGrupos(allGrupos2);

            if (categoriaActual.getAllGrupos().size() > 0 && hayPartidos) {
                allCategories2.add(categoriaActual);
            }
        } else if (allLlaves.size() > 0) {
            for (Llave llaveActual : allLlaves) {
                List<Partido> partidoList = new ArrayList<Partido>();

                //Se busca el Calendario por cada Llave
                partidoList = getListaPartidosLlaves(categoriaActual, llaveActual);
                llaveActual.setPartidoList(partidoList);

                if (partidoList.size() > 0) {
                    hayPartidos = true;
                    allLlaves2.add(llaveActual);
                }

                categoriaActual.setAllLlaves(allLlaves2);

                if (categoriaActual.getAllLlaves().size() > 0 && hayPartidos) {
                    allCategories2.add(categoriaActual);
                }
            }
        }

        return categoriaActual;
    }
    
    public List<Partido> getListaPartidosJornadas(Categoria categoria, Jornada jornada) {
        PartidoJpaControllerExt partidoJpaController = new PartidoJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Partido> partidos = null;
        partidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinJornada(categoria, jornada);

        return partidos;
    }
    
    public List<Partido> getListaPartidosLlaves(Categoria categoria, Llave llave) {
        PartidoJpaControllerExt partidoJpaController = new PartidoJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Partido> partidos = null;
        partidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinLlave(categoria, llave);

        return partidos;
    }
    
    public List<Clasifica> calcularClasificacion(Categoria categoria, Jornada jornada, Grupo grupo, Liga entity) {
        ClasificacionJpaControllerExt clasificacionJpaController = new ClasificacionJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Clasifica> clasificacion = new ArrayList<Clasifica>();
        int statusLocal = 1;
        int statusVisitante = 0;

        //  System.out.println("    Calculando Clasificación ---> Categoría: " + categoria.getNombre() + " Grupo: " + grupo.getNombre() + " Jornada: " + jornada.getNumero());

        if (categoria != null && jornada != null && grupo != null && entity != null) {
            //Obtengo la Clasificación Total del Equipo 
            List<Object[]> calcula = clasificacionJpaController.findClasificacionByCategoria(categoria, jornada, grupo, entity);

            for (Object[] objs : calcula) {
                Clasifica clasifica = new Clasifica();

                clasifica.setIdEquipo((objs[0]).hashCode());
                int idEquipoActual = clasifica.getIdEquipo();
                clasifica.setEquipoName(objs[1].toString());
                if ((objs[2]) != null) {
                    clasifica.setJjugados(String.valueOf(objs[2]));
                } else {
                    clasifica.setJjugados(String.valueOf("0"));
                }
                if ((objs[3]) != null) {
                    clasifica.setJganados(String.valueOf(objs[3]));
                } else {
                    clasifica.setJganados(String.valueOf("0"));
                }
                if ((objs[4]) != null) {
                    clasifica.setJempatados(String.valueOf(objs[4]));
                } else {
                    clasifica.setJempatados(String.valueOf("0"));
                }
                if ((objs[5]) != null) {
                    clasifica.setJperdidos(String.valueOf(objs[5]));
                } else {
                    clasifica.setJperdidos(String.valueOf("0"));
                }
                if ((objs[6]) != null) {
                    clasifica.setGfavor(String.valueOf(objs[6]));
                } else {
                    clasifica.setGfavor(String.valueOf("0"));
                }
                if ((objs[7]) != null) {
                    clasifica.setGcontra(String.valueOf(objs[7]));
                } else {
                    clasifica.setGcontra(String.valueOf("0"));
                }
                if ((objs[8]) != null) {
                    clasifica.setDiferencia(String.valueOf(objs[8]));
                } else {
                    clasifica.setDiferencia(String.valueOf("0"));
                }
                if ((objs[9]) != null) {
                    clasifica.setPuntos(String.valueOf(objs[9]));
                } else {
                    clasifica.setPuntos(String.valueOf("0"));
                }

                //Obtengo la Clasificación del Equipo como Local
                Object[] calculaLocal = clasificacionJpaController.findClasificacionLocalVisitanteByCategoria(idEquipoActual, categoria, jornada, grupo, entity, statusLocal);
                if ((calculaLocal[0]) != null) {
                    clasifica.setJjugadosLocal(String.valueOf(calculaLocal[0]));
                } else {
                    clasifica.setJjugadosLocal(String.valueOf("0"));
                }
                if ((calculaLocal[1]) != null) {
                    clasifica.setJganadosLocal(String.valueOf(calculaLocal[1]));
                } else {
                    clasifica.setJganadosLocal(String.valueOf("0"));
                }
                if ((calculaLocal[2]) != null) {
                    clasifica.setJempatadosLocal(String.valueOf(calculaLocal[2]));
                } else {
                    clasifica.setJempatadosLocal(String.valueOf("0"));
                }
                if ((calculaLocal[3]) != null) {
                    clasifica.setJperdidosLocal(String.valueOf(calculaLocal[3]));
                } else {
                    clasifica.setJperdidosLocal(String.valueOf("0"));
                }
                if ((calculaLocal[4]) != null) {
                    clasifica.setGfavorLocal(String.valueOf(calculaLocal[4]));
                } else {
                    clasifica.setGfavorLocal(String.valueOf("0"));
                }
                if ((calculaLocal[5]) != null) {
                    clasifica.setGcontraLocal(String.valueOf(calculaLocal[5]));
                } else {
                    clasifica.setGcontraLocal(String.valueOf("0"));
                }
                if ((calculaLocal[6]) != null) {
                    clasifica.setDiferenciaLocal(String.valueOf(calculaLocal[6]));
                } else {
                    clasifica.setDiferenciaLocal(String.valueOf("0"));
                }
                if ((calculaLocal[7]) != null) {
                    clasifica.setPuntosLocal(String.valueOf(calculaLocal[7]));
                } else {
                    clasifica.setPuntosLocal(String.valueOf("0"));
                }

                //Obtengo la Clasificación del Equipo como Visitante                                              
                Object[] calculaVisitante = clasificacionJpaController.findClasificacionLocalVisitanteByCategoria(idEquipoActual, categoria, jornada, grupo, entity, statusVisitante);
                if ((calculaVisitante[0]) != null) {
                    clasifica.setJjugadosVisitante(String.valueOf(calculaVisitante[0]));
                } else {
                    clasifica.setJjugadosVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[1]) != null) {
                    clasifica.setJganadosVisitante(String.valueOf(calculaVisitante[1]));
                } else {
                    clasifica.setJganadosVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[2]) != null) {
                    clasifica.setJempatadosVisitante(String.valueOf(calculaVisitante[2]));
                } else {
                    clasifica.setJempatadosVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[3]) != null) {
                    clasifica.setJperdidosVisitante(String.valueOf(calculaVisitante[3]));
                } else {
                    clasifica.setJperdidosVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[4]) != null) {
                    clasifica.setGfavorVisitante(String.valueOf(calculaVisitante[4]));
                } else {
                    clasifica.setGfavorVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[5]) != null) {
                    clasifica.setGcontraVisitante(String.valueOf(calculaVisitante[5]));
                } else {
                    clasifica.setGcontraVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[6]) != null) {
                    clasifica.setDiferenciaVisitante(String.valueOf(calculaVisitante[6]));
                } else {
                    clasifica.setDiferenciaVisitante(String.valueOf("0"));
                }
                if ((calculaVisitante[7]) != null) {
                    clasifica.setPuntosVisitante(String.valueOf(calculaVisitante[7]));
                } else {
                    clasifica.setPuntosVisitante(String.valueOf("0"));
                }

                clasificacion.add(clasifica);
            }
        }
        return clasificacion;
    }

     public class Clasifica {

        private int idEquipo;
        private String equipoName;
        private String jjugados;
        private String jganados;
        private String jempatados;
        private String jperdidos;
        private String gfavor;
        private String gcontra;
        private String diferencia;
        private String puntos;
        private String jjugadosLocal;
        private String jganadosLocal;
        private String jempatadosLocal;
        private String jperdidosLocal;
        private String gfavorLocal;
        private String gcontraLocal;
        private String diferenciaLocal;
        private String puntosLocal;
        private String jjugadosVisitante;
        private String jganadosVisitante;
        private String jempatadosVisitante;
        private String jperdidosVisitante;
        private String gfavorVisitante;
        private String gcontraVisitante;
        private String diferenciaVisitante;
        private String puntosVisitante;

        public int getIdEquipo() {
            return idEquipo;
        }

        public void setIdEquipo(int idEquipo) {
            this.idEquipo = idEquipo;
        }

        public String getEquipoName() {
            return equipoName;
        }

        public void setEquipoName(String equipoName) {
            this.equipoName = equipoName;
        }

        public String getJjugados() {
            if (jjugados == null) {
                return jjugados = "0";
            } else {
                return jjugados;
            }
        }

        public void setJjugados(String jjugados) {
            this.jjugados = jjugados;
        }

        public String getJganados() {
            if (jganados == null) {
                return jganados = "0";
            } else {
                return jganados;
            }
        }

        public void setJganados(String jganados) {
            this.jganados = jganados;
        }

        public String getJempatados() {
            if (jempatados == null) {
                return jempatados = "0";
            } else {
                return jempatados;
            }
        }

        public void setJempatados(String jempatados) {
            this.jempatados = jempatados;
        }

        public String getJperdidos() {
            if (jperdidos == null) {
                return jperdidos = "0";
            } else {
                return jperdidos;
            }
        }

        public void setJperdidos(String jperdidos) {
            this.jperdidos = jperdidos;
        }

        public String getGfavor() {
            if (gfavor == null) {
                return gfavor = "0";
            } else {
                return gfavor;
            }
        }

        public void setGfavor(String gfavor) {
            this.gfavor = gfavor;
        }

        public String getGcontra() {
            if (gcontra == null) {
                return gcontra = "0";
            } else {
                return gcontra;
            }
        }

        public void setGcontra(String gcontra) {
            this.gcontra = gcontra;
        }

        public String getDiferencia() {
            if (diferencia == null) {
                return diferencia = "0";
            } else {
                return diferencia;
            }
        }

        public void setDiferencia(String diferencia) {
            this.diferencia = diferencia;
        }

        public String getPuntos() {
            if (puntos == null) {
                return puntos = "0";
            } else {
                return puntos;
            }
        }

        public void setPuntos(String puntos) {
            this.puntos = puntos;
        }

        public String getDiferenciaLocal() {
            if (diferenciaLocal == null) {
                return diferenciaLocal = "0";
            } else {
                return diferenciaLocal;
            }
        }

        public void setDiferenciaLocal(String diferenciaLocal) {
            this.diferenciaLocal = diferenciaLocal;
        }

        public String getDiferenciaVisitante() {
            if (diferenciaVisitante == null) {
                return diferenciaVisitante = "0";
            } else {
                return diferenciaVisitante;
            }
        }

        public void setDiferenciaVisitante(String diferenciaVisitante) {
            this.diferenciaVisitante = diferenciaVisitante;
        }

        public String getGcontraLocal() {
            if (gcontraLocal == null) {
                return gcontraLocal = "0";
            } else {
                return gcontraLocal;
            }
        }

        public void setGcontraLocal(String gcontraLocal) {
            this.gcontraLocal = gcontraLocal;
        }

        public String getGcontraVisitante() {
            if (gcontraVisitante == null) {
                return gcontraVisitante = "0";
            } else {
                return gcontraVisitante;
            }
        }

        public void setGcontraVisitante(String gcontraVisitante) {
            this.gcontraVisitante = gcontraVisitante;
        }

        public String getGfavorLocal() {
            if (gfavorLocal == null) {
                return gfavorLocal = "0";
            } else {
                return gfavorLocal;
            }
        }

        public void setGfavorLocal(String gfavorLocal) {
            this.gfavorLocal = gfavorLocal;
        }

        public String getGfavorVisitante() {
            if (gfavorVisitante == null) {
                return gfavorVisitante = "0";
            } else {
                return gfavorVisitante;
            }
        }

        public void setGfavorVisitante(String gfavorVisitante) {
            this.gfavorVisitante = gfavorVisitante;
        }

        public String getJempatadosLocal() {
            if (jempatadosLocal == null) {
                return jempatadosLocal = "0";
            } else {
                return jempatadosLocal;
            }
        }

        public void setJempatadosLocal(String jempatadosLocal) {
            this.jempatadosLocal = jempatadosLocal;
        }

        public String getJempatadosVisitante() {
            if (jempatadosVisitante == null) {
                return jempatadosVisitante = "0";
            } else {
                return jempatadosVisitante;
            }
        }

        public void setJempatadosVisitante(String jempatadosVisitante) {
            this.jempatadosVisitante = jempatadosVisitante;
        }

        public String getJganadosLocal() {
            if (jganadosLocal == null) {
                return jganadosLocal = "0";
            } else {
                return jganadosLocal;
            }
        }

        public void setJganadosLocal(String jganadosLocal) {
            this.jganadosLocal = jganadosLocal;
        }

        public String getJganadosVisitante() {
            if (jganadosVisitante == null) {
                return jganadosVisitante = "0";
            } else {
                return jganadosVisitante;
            }
        }

        public void setJganadosVisitante(String jganadosVisitante) {
            this.jganadosVisitante = jganadosVisitante;
        }

        public String getJjugadosLocal() {
            if (jjugadosLocal == null) {
                return jjugadosLocal = "0";
            } else {
                return jjugadosLocal;
            }
        }

        public void setJjugadosLocal(String jjugadosLocal) {
            this.jjugadosLocal = jjugadosLocal;
        }

        public String getJjugadosVisitante() {
            if (jjugadosVisitante == null) {
                return jjugadosVisitante = "0";
            } else {
                return jjugadosVisitante;
            }
        }

        public void setJjugadosVisitante(String jjugadosVisitante) {
            this.jjugadosVisitante = jjugadosVisitante;
        }

        public String getJperdidosLocal() {
            if (jperdidosLocal == null) {
                return jperdidosLocal = "0";
            } else {
                return jperdidosLocal;
            }
        }

        public void setJperdidosLocal(String jperdidosLocal) {
            this.jperdidosLocal = jperdidosLocal;
        }

        public String getJperdidosVisitante() {
            if (jperdidosVisitante == null) {
                return jperdidosVisitante = "0";
            } else {
                return jperdidosVisitante;
            }
        }

        public void setJperdidosVisitante(String jperdidosVisitante) {
            this.jperdidosVisitante = jperdidosVisitante;
        }

        public String getPuntosLocal() {
            if (puntosLocal == null) {
                return puntosLocal = "0";
            } else {
                return puntosLocal;
            }
        }

        public void setPuntosLocal(String puntosLocal) {
            this.puntosLocal = puntosLocal;
        }

        public String getPuntosVisitante() {
            if (puntosVisitante == null) {
                return puntosVisitante = "0";
            } else {
                return puntosVisitante;
            }
        }

        public void setPuntosVisitante(String puntosVisitante) {
            this.puntosVisitante = puntosVisitante;
        }
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    public int getTotalPartidoList() {
        return totalPartidoList;
    }

    public void setTotalPartidoList(int totalPartidoList) {
        this.totalPartidoList = totalPartidoList;
    }

    public Grupo getGrupoActual() {
        return grupoActual;
    }

    public void setGrupoActual(Grupo grupoActual) {
        this.grupoActual = grupoActual;
    }

    public Jornada getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(Jornada jornadaActual) {
        this.jornadaActual = jornadaActual;
    }

    public boolean isHayPartidos() {
        return hayPartidos;
    }

    public void setHayPartidos(boolean hayPartidos) {
        this.hayPartidos = hayPartidos;
    }
}

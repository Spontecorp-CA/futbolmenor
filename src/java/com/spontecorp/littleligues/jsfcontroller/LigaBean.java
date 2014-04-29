/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spontecorp.littleligues.jsfcontroller;

import com.spontecorp.littleligues.jpacontroller.VideoJpaController;
import com.spontecorp.littleligues.jpacontroller.extentions.*;
import com.spontecorp.littleligues.model.Noticia;
import com.spontecorp.littleligues.model.Video;
import com.spontecorp.littleligues.model.liga.Categoria;
import com.spontecorp.littleligues.model.liga.Equipo;
import com.spontecorp.littleligues.model.liga.Liga;
import com.spontecorp.littleligues.model.torneo.*;
import com.spontecorp.littleligues.utils.LittleLiguesUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author zuleidyb
 */
@ManagedBean(name = "ligaBean")
@SessionScoped
public final class LigaBean implements Serializable {

    private transient LigaJpaControllerExt jpaController = null;
    private transient DataModel<Liga> ligas;
    private transient DataModel<Noticia> noticiasLiga;
    private transient DataModel<Video> videosLiga;
    private List<Grupo> listaGrupos = null;
    private List<Llave> listaLlaves = null;
    private List<Partido> listaPartidos = null;
    private List<Equipo> listaEquipos = null;
    private List<Categoria> categorias = null;
    private List<Fase> listaFases = null;
    private Liga entity;
    private Noticia noticia;
    private Temporada lastTemporadaLiga;
    private Fase fase = null;
    private Grupo grupo;
    private Llave llave;
    private Jornada jornada;
    private Categoria categoria;
    private int totalGrupos = 0;
    private int totalLlaves = 0;
    private int totalFases = 0;
    private int idFase = -1;
    private int idGrupo = -1;
    private int idLlave = -1;
    private int idCategoria = -1;
    private int idEquipo = -1;
    private String activeTab = null;
    private static Map<String, Integer> listFases;
    private static Map<Integer, Integer> listJornadas;
    private Integer selectedFase = null;
    private Integer selectedJornada = null;
    private String selectedTab = null;
    private int totalPartidos = 0;
    private int idJornadaActual = -1;
    private Jornada jornadaActual;

    public LigaBean() {
    }

    private LigaJpaControllerExt getJpaController() {
        if (jpaController == null) {
            jpaController = new LigaJpaControllerExt(LittleLiguesUtils.getEmf());
        }
        return jpaController;
    }

    /**
     * Listado de Ligas
     *
     * @return
     */
    public DataModel<Liga> getLigas() {
        if (ligas == null) {
            ligas = new ListDataModel(getJpaController().findLigaEntities());
        }
        return ligas;
    }

    /**
     * Liga Actual
     *
     * @return
     */
    public Liga getEntity() {
        if (entity == null) {
            entity = new Liga();
        }
        return entity;
    }

    /**
     * Noticia Actual Ligas
     *
     * @return
     */
    public Noticia getNoticia() {
        if (noticia == null) {
            noticia = new Noticia();
        }
        return noticia;
    }

    /**
     * Noticial Liga Seleccionada
     *
     * @return
     */
    public String selectedNoticia() {
        //Capturo la Noticia seleccionada
        FacesContext context = FacesContext.getCurrentInstance();
        int idSelectedNoticia = context.getExternalContext().getRequestParameterMap().get("idSelectedNoticia") != null ? Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idSelectedNoticia")) : -1;
        noticia = null;
        noticia = getJpaController().findNoticia(idSelectedNoticia);

        return "verNoticiaLiga?faces-redirect=true";
    }

    /**
     *
     */
    private void recreateModel() {
        noticiasLiga = null;
        lastTemporadaLiga = null;
        listaFases = null;
        videosLiga = null;
    }

    /**
     * Lista de Noticias asociadas a la Liga Seleccionada Ordenadas por fecha
     * Orden DESC
     *
     * @return
     */
    public DataModel<Noticia> getNoticiasLiga() {
        recreateModel();
        if (noticiasLiga == null) {
            List<Noticia> lista = getJpaController().findNoticiasLigaEntities(entity);
            noticiasLiga = new ListDataModel(lista);
        }
        return noticiasLiga;
    }

    /**
     * Lista de Videos asociados a la Liga Seleccionada Ordenados por fecha
     * Orden DESC
     *
     * @return
     */
    public DataModel<Video> getVideosLiga() {
        recreateModel();
        VideoJpaController videoJpaController = new VideoJpaController(LittleLiguesUtils.getEmf());
        if (videosLiga == null) {
            List<Video> lista = videoJpaController.findVideosLigaEntities(entity);
            videosLiga = new ListDataModel(lista);
        }
        return videosLiga;
    }

    private void recreateLigaModel() {
        listaGrupos = null;
        listaLlaves = null;
        selectedFase = null;
        selectedJornada = null;
        listJornadas = null;
        listFases = null;
        listaPartidos = null;
        listaEquipos = null;
        fase = null;
        jornada = null;
        idFase = -1;
        idGrupo = -1;
        idLlave = -1;
        idCategoria = -1;
        idEquipo = -1;
        selectedTab = null;
        totalPartidos = 0;
        totalGrupos = 0;
        totalFases = 0;
        totalLlaves = 0;
    }

    /*
     * Obtengo los Datos de la Liga Seleccionada
     *
     * @return
     */
    public String selectedLiga() {

        recreateLigaModel();

        entity = (Liga) ligas.getRowData();

        return "indexLigas?faces-redirect=true";
    }

    /**
     * Metodo para obtener la última temporada ordenada por fecha fin Orden DESC
     *
     * @return
     */
    public Temporada getLastTemporadaLiga() {

        recreateModel();
        FacesContext context = FacesContext.getCurrentInstance();
        FaseJpaControllerExt faseJpaController = new FaseJpaControllerExt(LittleLiguesUtils.getEmf());

        //Capturo el id del Tab Activo
        String idTab = context.getExternalContext().getRequestParameterMap().get("tab") != null ? context.getExternalContext().getRequestParameterMap().get("tab") : null;

        if (idTab == null && selectedTab == null) {
            idTab = "tab1";
        }

        selectedTab = idTab;

        //Busco la ultima Temporada de la Liga
        if (lastTemporadaLiga == null) {
            lastTemporadaLiga = getJpaController().findLastTemporadaLiga(entity);
        }

        if (lastTemporadaLiga != null) {
            //Listo Fases de la ultima Temporada
            if (listaFases == null) {
                listaFases = faseJpaController.findFasesOnTemporada(lastTemporadaLiga);

                if (listaFases != null) {
                    //Total Fases
                    totalFases = listaFases.size();
                    
                    //Busco la Fase marcada como actual
                    fase = faseJpaController.findCurrentFase(lastTemporadaLiga);

                    if (fase == null) {
                        fase = listaFases.get(0);
                        fase.setIsCurrent(1);
                    }
                }
            }
        }

        return lastTemporadaLiga;
    }

    /**
     * Recargo la pagina posicionándola en Calendario
     *
     * @throws IOException
     */
    public void reloadIndexLigas() throws IOException {
        getLastTemporadaLiga();
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexLigas.xhtml#" + selectedTab);
    }

    /**
     *
     * @param tab
     * @throws IOException
     */
    public void reloadIndexLigasJornada(String tab) throws IOException {
        getLastTemporadaLiga();
        //System.out.println("tab: "+tab);
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexLigas.xhtml#" + tab);
    }

    /**
     * Listado de Fases de la Temporada seleccionada
     *
     * @param x
     */
    public void faseChanged(ValueChangeEvent x) throws IOException {
        FaseJpaControllerExt faseJpaController = new FaseJpaControllerExt(LittleLiguesUtils.getEmf());
        //assign new value to selectedFase
        selectedFase = (Integer) x.getNewValue();
        fase = faseJpaController.findFase(selectedFase);
        listaGrupos = null;
        listaLlaves = null;
        selectedJornada = null;
        listJornadas = null;
        reloadIndexLigas();
    }

    /**
     * Listado de Jornadas del Grupo seleccionado
     *
     * @param x
     */
    public void jornadaChangedTab1(ValueChangeEvent x) throws IOException {
        JornadaJpaControllerExt jornadaJpaController = new JornadaJpaControllerExt(LittleLiguesUtils.getEmf());
        //assign new value to selectedJornada
        selectedJornada = (Integer) x.getNewValue();
        jornada = jornadaJpaController.findJornada(selectedJornada);
        idGrupo = grupo.getId();
        String tab = "tab1";
        reloadIndexLigasJornada(tab);
    }

    /**
     * Listado de Jornadas del Grupo seleccionado
     *
     * @param x
     */
    public void jornadaChangedTab2(ValueChangeEvent x) throws IOException {
        JornadaJpaControllerExt jornadaJpaController = new JornadaJpaControllerExt(LittleLiguesUtils.getEmf());
        //assign new value to selectedJornada
        selectedJornada = (Integer) x.getNewValue();
        jornada = jornadaJpaController.findJornada(selectedJornada);
        idGrupo = grupo.getId();
        String tab = "tab2";
        reloadIndexLigasJornada(tab);
    }

    /**
     * Listado de Jornadas del Grupo seleccionado
     *
     * @param x
     */
    public void jornadaChangedTab3(ValueChangeEvent x) throws IOException {
        JornadaJpaControllerExt jornadaJpaController = new JornadaJpaControllerExt(LittleLiguesUtils.getEmf());
        //assign new value to selectedJornada
        selectedJornada = (Integer) x.getNewValue();
        jornada = jornadaJpaController.findJornada(selectedJornada);
        idGrupo = grupo.getId();
        String tab = "tab3";
        reloadIndexLigasJornada(tab);
    }

    /**
     * Lista de Grupos de la Fase Seleccionada
     *
     * @return
     */
    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    /**
     * Lista de Llaves de la Fase Seleccionada
     *
     * @return
     */
    public List<Llave> getListaLlaves() {
        return listaLlaves;
    }

    /**
     * Lista de Partidos para la Categoria y Jornada seleccionada
     *
     * @return
     */
    public List<Partido> getListaPartidos() {
        PartidoJpaControllerExt partidoJpaController = new PartidoJpaControllerExt(LittleLiguesUtils.getEmf());
        listaPartidos = null;
        if (categoria != null) {
            if (totalGrupos > 0 && jornada != null) {
                listaPartidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinJornada(categoria, jornada);
            } else if (totalLlaves > 0 && llave != null) {
                listaPartidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinLlave(categoria, llave);
            }
        }
        if (listaPartidos != null) {
            totalPartidos = listaPartidos.size();
        } else {
            totalPartidos = 0;
        }
        return listaPartidos;
    }

    /**
     * Método para obtener la Clasificación Total tomando en cuenta la
     * Categoria, Jornada y Grupo de la Liga seleccionada
     *
     * @return
     */
    public List<Clasifica> getClasificacion() {
        ClasificacionJpaControllerExt clasificacionJpaController = new ClasificacionJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Clasifica> clasificacion = new ArrayList<Clasifica>();
        int statusLocal = 1;
        int statusVisitante = 0;

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

    /**
     * Lista de Categorías con sus Clasificaciones Este es el método que se
     * llama desde .xhtml
     *
     * @return
     */
    public List<Categoria> getClassification() {
        CategoriaJpaControllerExt categoriaJpaController = new CategoriaJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Categoria> allCategories = categoriaJpaController.findListCategoria();
        List<Categoria> allCategories2 = new ArrayList<Categoria>();

        for (Categoria categoriaActual : allCategories) {
            Categoria cat = calcClassification(categoriaActual);
            allCategories2.add(cat);
        }

        return allCategories2;
    }

    /**
     * Obtengo la Clasificación por Categoría
     *
     * @param categoria
     * @return
     */
    public Categoria calcClassification(Categoria categoria) {

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

                    List<Clasifica> tableClasif = calcularClasificacion(categoriaActual, jornadaActual, grupoActual, entity);

                    //Se busca el Calendario por cada Jornada
                    partidoList = getListaPartidosJornadas(categoriaActual, jornadaActual);
                    jornadaActual.setPartidoJornada(partidoList);

                    if (partidoList.size() > 0) {
                        hayPartidos = true;
                    }

                    if (tableClasif.size() > 0) {
                        jornadaActual.setClasifica(tableClasif);
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

    /**
     * Metodo para obtener la Lista de Partidos de cada Categoria por cada
     * Jornada
     *
     * @param categoria
     * @param jornada
     * @return
     */
    public List<Partido> getListaPartidosJornadas(Categoria categoria, Jornada jornada) {
        PartidoJpaControllerExt partidoJpaController = new PartidoJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Partido> partidos = null;
        partidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinJornada(categoria, jornada);

        return partidos;
    }

    /**
     * Metodo para obtener la Lista de Partidos de cada Categoria por cada Llave
     *
     * @param categoria
     * @param llave
     * @return
     */
    public List<Partido> getListaPartidosLlaves(Categoria categoria, Llave llave) {
        PartidoJpaControllerExt partidoJpaController = new PartidoJpaControllerExt(LittleLiguesUtils.getEmf());
        List<Partido> partidos = null;
        partidos = partidoJpaController.findPartidoEntitiesOnCategoriaWithinLlave(categoria, llave);

        return partidos;
    }

    /**
     * Se calcula la Clasificación per se
     *
     * @param categoria
     * @param jornada
     * @param grupo
     * @param entity
     * @return
     */
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

    /**
     * Lista de Equipos según la Liga y la Categoría seleccionada Ordenados por
     * nombre en forma ASC
     *
     * @return
     */
    public List<Equipo> getListaEquipos() {

        EquipoJpaControllerExt equipoJpaController = new EquipoJpaControllerExt(LittleLiguesUtils.getEmf());
        listaEquipos = null;
        if (categoria != null && entity != null) {
            listaEquipos = equipoJpaController.findEquiposOnCategoriaLiga(categoria, entity);
        }

        if (listaEquipos.size() > 0) {
            idEquipo = listaEquipos.get(0).getId();
        }

        return listaEquipos;
    }

    public Integer getSelectedFase() {
        return selectedFase;
    }

    public void setSelectedFase(Integer selectedFase) {
        this.selectedFase = selectedFase;
    }

    public Integer getSelectedJornada() {
        return selectedJornada;
    }

    public void setSelectedJornada(Integer selectedJornada) {
        this.selectedJornada = selectedJornada;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Llave getLlave() {
        return llave;
    }

    public void setLlave(Llave llave) {
        this.llave = llave;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public int getTotalGrupos() {
        return totalGrupos;
    }

    public void setTotalGrupos(int totalGrupos) {
        this.totalGrupos = totalGrupos;
    }

    public int getTotalLlaves() {
        return totalLlaves;
    }

    public void setTotalLlaves(int totalLaves) {
        this.totalLlaves = totalLaves;
    }

    public int getTotalFases() {
        return totalFases;
    }

    public void setTotalFases(int totalFases) {
        this.totalFases = totalFases;
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

    public int getIdLlave() {
        return idLlave;
    }

    public void setIdLlave(int idLlave) {
        this.idLlave = idLlave;
    }

    public List<Fase> getListaFases() {
        return listaFases;
    }

    public Map<String, Integer> getFasesInMap() {
        return listFases;
    }

    public Map<Integer, Integer> getJornadasInMap() {
        return listJornadas;
    }

    public void setListaFases(List<Fase> listaFases) {
        this.listaFases = listaFases;
    }

    public static Map<String, Integer> getListFases() {
        return listFases;
    }

    public static void setListFases(Map<String, Integer> listFases) {
        LigaBean.listFases = listFases;
    }

    public static Map<Integer, Integer> getListJornadas() {
        return listJornadas;
    }

    public static void setListJornadas(Map<Integer, Integer> listJornadas) {
        LigaBean.listJornadas = listJornadas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
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

    public int getTotalPartidos() {
        return totalPartidos;
    }

    public void setTotalPartidos(int totalPartidos) {
        this.totalPartidos = totalPartidos;
    }

    public int getIdJornadaActual() {
        return idJornadaActual;
    }

    public void setIdJornadaActual(int idJornadaActual) {
        this.idJornadaActual = idJornadaActual;
    }

    public Jornada getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(Jornada jornadaActual) {
        this.jornadaActual = jornadaActual;
    }
}

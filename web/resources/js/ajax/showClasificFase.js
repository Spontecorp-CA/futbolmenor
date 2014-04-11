var xmlHttpClasificFase;

function showClasificFase(idLiga, idFase, pos, totalFases)
{
    //alert("Liga: " + idLiga + " idFase: " + idFase + " pos: "+pos);
      
    xmlHttpClasificFase=GetXmlHttpObjectClasificFase()
    if (xmlHttpClasificFase==null)
    {
        alert ("Su navegador no soporta AJAX!");
        return;
    }
    var url="ajax/showClasificFase.xhtml?idLiga="+idLiga+"&idFase="+idFase+"&rand="+Math.random();
    xmlHttpClasificFase.onreadystatechange=stateChangedClasificFase;
    xmlHttpClasificFase.open("GET", url, true);
    xmlHttpClasificFase.send(null);
    
    
    showClasificSelected(pos, totalFases);
}
function stateChangedClasificFase() 
{ 
    if (xmlHttpClasificFase.readyState==4)
    { 
        document.getElementById("cargaClasificFase").innerHTML=xmlHttpClasificFase.responseText;
    }
    else document.getElementById("cargaClasificFase").innerHTML='<div style="margin-left:50%;padding-top:0px;color:#cccccc;"><image src="resources/images/ajax-loader.gif"/></div>'; 
} 

function GetXmlHttpObjectClasificFase()
{
    var xmlHttpClasificFase=null;
    try
    { // Firefox, Opera 8.0+, Safari...
        xmlHttpClasificFase=new XMLHttpRequest();
    }
    catch (e)
    {
        // Internet Explorer...
        try
        {
            xmlHttpClasificFase=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e)
        {
            xmlHttpClasificFase=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttpClasificFase;
}
    


//Manejo de Estilos
function showClasificSelected(pos, totalFases){  
    //alert("1.- Entro a showCalendarClasificSelected --> totalFases: " + totalFases + " pos: "+pos)
    for (x=1; x <= totalFases; x++){
        if(pos == 1){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 2){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 3){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 4){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 5){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 6){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 7){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 8){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 9){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 10){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 11){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 12){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 13){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 14){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }
        if(pos == 15){ 
            document.getElementById('clasificFaseSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("clasificFaseSelected"+x).className='texto_interno6'; 
        }        
    }
    showResetClasificFaseSelected(pos);
}

//Manejo de Estilos
function showResetClasificFaseSelected(pos){   
    //alert("2.- Entro a showResetclasificFaseSelected --> pos: "+pos)
    if(pos == 1){
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 2){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 3){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 4){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 5){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 6){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 7){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 8){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 9){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 10){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    }
    if(pos == 11){
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 12){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 13){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 14){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 15){ 
        document.getElementById('clasificFaseSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textClasificFaseSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    }
}



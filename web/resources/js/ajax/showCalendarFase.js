var xmlHttpCalendarFase;

function showCalendarFase(idLiga, idFase, pos, totalFases)
{
    //alert("Liga: " + idLiga + " idFase: " + idFase + " pos: "+pos);
      
    xmlHttpCalendarFase=GetXmlHttpObjectCalendarFase()
    if (xmlHttpCalendarFase==null)
    {
        alert ("Su navegador no soporta AJAX!");
        return;
    }
    var url="ajax/showCalendarFase.xhtml?idLiga="+idLiga+"&idFase="+idFase+"&rand="+Math.random();
    xmlHttpCalendarFase.onreadystatechange=stateChangedCalendarFase;
    xmlHttpCalendarFase.open("GET", url, true);
    xmlHttpCalendarFase.send(null);
    
    
    showCalendarFaseSelected(pos, totalFases);
}
function stateChangedCalendarFase() 
{ 
    if (xmlHttpCalendarFase.readyState==4)
    { 
        document.getElementById("cargaCalendarFase").innerHTML=xmlHttpCalendarFase.responseText;
    }
    else document.getElementById("cargaCalendarFase").innerHTML='<div style="margin-left:50%;padding-top:0px;color:#cccccc;"><image src="resources/images/ajax-loader.gif"/></div>'; 
} 

function GetXmlHttpObjectCalendarFase()
{
    var xmlHttpCalendarFase=null;
    try
    { // Firefox, Opera 8.0+, Safari...
        xmlHttpCalendarFase=new XMLHttpRequest();
    }
    catch (e)
    {
        // Internet Explorer...
        try
        {
            xmlHttpCalendarFase=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e)
        {
            xmlHttpCalendarFase=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttpCalendarFase;
}
    


//Manejo de Estilos
function showCalendarFaseSelected(pos, totalFases){  
    //alert("1.- Entro a showCalendarFaseSelected --> totalFases: " + totalFases + " pos: "+pos)
    for (x=1; x <= totalFases; x++){
        if(pos == 1){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 2){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 3){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 4){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 5){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 6){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 7){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 8){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 9){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 10){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 11){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 12){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 13){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 14){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }
        if(pos == 15){ 
            document.getElementById('faseCalendarSelected'+x).setAttribute('style', 'background: #8B8B8B; border-bottom: 0px; font-size: 14px; font-color:#000; border-left: 2px solid #FFFFFF; width:4%; text-align: center; cursor: pointer');
            document.getElementById("faseCalendarSelected"+x).className='texto_interno6'; 
        }        
    }
    showResetFaseCalendarSelected(pos, totalFases);
}

//Manejo de Estilos
function showResetFaseCalendarSelected(pos, totalFases){   
    //alert("2.- Entro a showResetFaseCalendarSelected --> pos: "+pos)
    if(pos == 1){
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 2){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 3){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 4){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 5){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 6){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 7){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 8){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 9){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 10){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    }
    if(pos == 11){
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 12){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 13){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 14){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    } 
    if(pos == 15){ 
        document.getElementById('faseCalendarSelected'+pos).setAttribute('style', 'background: #39B549; border-bottom: 0px; border-left: 2px solid #FFFFFF; font-color:#FFFFFF; width:4%; text-align: center; cursor: pointer; height: 35px;');
        document.getElementById('textFaseCalendarSelected'+pos).setAttribute('style', 'font-color:#FFFFFF');   
    }
}



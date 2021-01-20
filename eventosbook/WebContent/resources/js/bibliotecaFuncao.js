
//Verifica se a tecla digitada é uma tecla funcional
function isTeclaFuncional(pEvento, pIgnorarBackSpace, pIgnorarDelete) {
	var retorno = false;

	if (pEvento != null) {
		keyCode = pEvento.keyCode;
		
		switch(keyCode) {
			case 8  : // backspace
				if (pIgnorarBackSpace) {
					retorno = false;
				} else {
					retorno = true;
				}
				break; 
			case 9  : retorno = true;break; //
			case 13 : retorno = true;break; //enter
			case 16 : retorno = true;break; //
			case 18 : retorno = true;break; //alt
			case 17 : retorno = true;break; //
			case 27 : retorno = true;break; //esc
			case 35 : retorno = true;break; //
			case 36 : retorno = true;break; //
			case 37 : retorno = true;break; //
			case 38 : retorno = true;break; //
			case 39 : retorno = true;break; //
			case 40 : retorno = true;break;	//
			case 46 : // delete
				if (pIgnorarDelete) {
					retorno = false;
				} else {
					retorno = true;
				}
		}
	}

	return retorno;
}

/**Ignora o submit ao apertar ENTER no formulário. Os campos pode ser configuráveis.
 * 
 * @param pEvento
 * @returns {Boolean}
 */
function ignoraSubmitFormOnEnter(pEvento){
	retorno = false;
	var elementoAtual;
	if (pEvento != null) {
		keyCode = pEvento.keyCode;
		if(keyCode == 13){
			elementoAtualId = document.activeElement;
			elementoAtual = document.activeElement.tagName;
			
			switch(elementoAtual) {
				case "BUTTON"    : retorno = true;break; 
				case "TEXTAREA"  : retorno = true;break;
				case "SELECT"	 : retorno = false;break;
				case "INPUT"	 : retorno = false;break;
			}
			
			if(retorno == false){
				pEvento.preventDefault();
			}
			
		}
		
	}

	return retorno;
	
}

/**Coloca focus no próximo elemento passando o id="" do próximo elemento.
 * 
 * @param pEvento
 * @param pProxIdElemento
 */
function focusProxElementoOnEnter(pEvento, pProxIdElemento){
	var campo = document.getElementById(pProxIdElemento);
	
	if (pEvento != null) {
		keyCode = pEvento.keyCode;
		if(keyCode == 13){
			campo.focus();
		}
	}
}


function marcardesmarcar() {
    $('.checkboxes').each(function () {
        if (this.checked) $(this).attr("checked", false);
        else $(this).prop("checked", true);
    });
}



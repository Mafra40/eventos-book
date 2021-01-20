
//retorna a data atual.
function getDataAtual(){
	var hoje = new Date();
	var dd = hoje.getDate();
	var mm = hoje.getMonth()+1; //Jan é 0!
	var yyyy = hoje.getFullYear();

	if(dd<10) {
		dd='0'+dd
	} 

	if(mm<10) {
		mm='0'+mm
	} 

	return hoje = mm+'/'+dd+'/'+yyyy;
}

//retorna ano atual.
function getAnoAtual(){
	var dataAtual = getDataAtual();
	
	var ano = (dataAtual.substring(6, 10));
	return parseInt(ano);
	
}


function formatarCampoData(pCampo, pEvento, pInMesAno) {
	var vlCampo = pCampo.value;
	var tam = vlCampo.length;
	var anoAtual = getAnoAtual();
	var anoLimite = anoAtual + 100;
	
	if (isTeclaFuncional(pEvento)) {
		return;
	}
	
	if (pEvento != null && pEvento.keyCode == 111) {
		if (vlCampo.length != 3 && vlCampo.length != 6) {
			pCampo.value = vlCampo.substr(0, tam - 1);
		}
		return;
	}

	var filtro = /^([0-9\/])*$/;
	if (!filtro.test(vlCampo)) {
		pCampo.value = vlCampo.substr(0, tam - 1);
		alert("Data invalida");
		pCampo.Focus();
		return;
	}

	if (vlCampo.length == 2 && vlCampo.charAt(2) != '/') {
		vlCampo = vlCampo + '/';
		pCampo.value = vlCampo;
	}
	if (vlCampo.length > 2 && vlCampo.charAt(2) != '/') {
		vlCampo = vlCampo.substring(0, 2) + '/' + vlCampo.substring(2);
		pCampo.value = vlCampo;
	}

	if (vlCampo.length == 5) {
		if (pInMesAno) {
			if (vlCampo.substr(3, 4) <= 12) {
				vlCampo = vlCampo + '/';
				pCampo.value = vlCampo;
			}
		} else {
			vlCampo = vlCampo + '/';
			pCampo.value = vlCampo;
		}
	}
	if (vlCampo.length > 5 && vlCampo.charAt(5) != '/') {
		vlCampo = vlCampo.substring(0, 5) + '/' + vlCampo.substring(5);
		pCampo.value = vlCampo;
	}

	if (vlCampo.length > 6 && vlCampo.charAt(6) == '0') {
		alert("Data invalida! O ano deve ser maior ou igual a 1900!");
		pCampo.focus();
		return;
	} else if (vlCampo.length > 7 && parseInt(vlCampo.substring(6, 8)) < 19) {
		
		alert("Data invalida! O ano deve ser maior ou igual a 1900!");
		pCampo.focus();
		return;
	} else if (vlCampo.length > 7 && parseInt(vlCampo.substring(6, 10)) > anoLimite) {
	
		alert("Data invalida! O ano deve ser menor ou igual a" + anoLimite + " .");
		pCampo.focus();
		return;
	}

	if (pInMesAno && vlCampo.length >= 7) {
		if (vlCampo.substr(3, 4) > 12) {
			isCampoDataValido(pCampo, null);
		}
	}

	if (vlCampo.length == 10) {
		isCampoDataValido(pCampo, null);
	}
}



// Verifica se existe uma data válida
// @pCampo data a ser validada

function isCampoDataValido(pCampo, pInObrigatorio, pInMesAno, pSemMensagem, pSemFocarCampo) {
	var msg = "";
	var vlCampo = pCampo.value;
	var anoAtual = getAnoAtual();
	var anoLimite = anoAtual + 100;
	
	if (pInObrigatorio != null || (typeof pInObrigatorio) == "undefined") {
		if (pInObrigatorio) {
			msg = "\n" + mensagemGlobal(0);

		} else {
			msg = "\n" + mensagemGlobal(1);

			if (vlCampo == "")
				return true;
		}
	}

	if (pInMesAno && vlCampo.length == 7) {
		var filtro = /^[0-9]{2}\/[0-9]{4}$/;
		if (!filtro.test(vlCampo)) {
			if (!pSemFocarCampo) {
				pCampo.focus();
			}
			if (!pSemMensagem) {
				exibirMensagem(mensagemGlobal(120) + msg);
			}
			if (!pSemFocarCampo) {
				focarCampo(pCampo);
			}
	
			return false;
		}
	
		dia = 01;
		mes = (vlCampo.substring(0, 2));
		ano = (vlCampo.substring(3, 7));

	} else {
		var filtro = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;
		if (!filtro.test(vlCampo)) {
			if (!pSemFocarCampo) {
				pCampo.focus();
			}
			if (!pSemMensagem) {
				exibirMensagem(mensagemGlobal(120) + msg);
			}
			if (!pSemFocarCampo) {				
				pCampo.focus();
			}
	
			return false;
		}
	
		dia = (vlCampo.substring(0, 2));
		mes = (vlCampo.substring(3, 5));
		ano = (vlCampo.substring(6, 10));
	}
	
	//exibirMensagem('dia '+dia);
	//exibirMensagem('mes '+mes);
	//exibirMensagem('ano '+ano);

	situacao = "";
	// verifica o dia valido para cada mes 
	if ((dia < 1) || (dia < 1 || dia > 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11) || dia > 31) {
		situacao = "falsa";
	}

	// verifica se o mes e valido 
	if (mes < 1 || mes > 12) {
		situacao = "falsa";
	}

	// verifica se ano eh valido
	if (ano < 1900) {
		situacao = "falsa";
		msg = "\n" + mensagemGlobal(133);
	}
	if (ano > anoLimite) {
		situacao = "falsa";
		msg = "\n" + mensagemGlobal(143).replace(CD_CAMPO_SUBSTITUICAO, anoLimite);
	}

	// verifica se e ano bissexto 
	if (mes == 2 && (dia < 1 || dia > 29 || (dia > 28 && (parseInt(ano / 4) != ano / 4)))) {
		situacao = "falsa";
	}

	if (pCampo.value == "") {
		situacao = "falsa";
	}

	if (situacao == "falsa") {
		if (!pSemFocarCampo) {
			pCampo.focus();
		}
		if (!pSemMensagem) {
			exibirMensagem(mensagemGlobal(120) + msg);
		}
		if (!pSemFocarCampo) {
			focarCampo(pCampo);
		}

		return false;
	}

	return true;
}
function startAjaxRequest() {
	var divAjax = getDivAjax('divAjaxRequest');
	divAjax.className = 'ajaxModalVisivel';
}

function endAjaxRequest() {
	var divAjax = getDivAjax('divAjaxRequest');
	divAjax.className = 'ajaxModalInvisivel';
}

function getDivAjax(elementName) {
	var divAjax = document.getElementById(elementName);
	if (divAjax == null) {
		var formulario = document.getElementsByTagName("form")[0];

		var newdiv = document.createElement('div');
		newdiv.setAttribute('id', elementName);
		newdiv.setAttribute('class', "ajaxModalInvisivel");

		var newImg = document.createElement('img');
		newImg.setAttribute('alt', "Aguarde...");
		newImg.setAttribute('src', "/sisgea/imagens/loading.gif");
		newImg.setAttribute('style', "margin-top: 80px;");

		newdiv.appendChild(newImg);

		formulario.appendChild(newdiv);

		divAjax = newdiv;
	}
	return divAjax;
}

function verificaSeNumero(campo) {

	fcn_numr = campo.value;

	var fcn_i;

	for (fcn_i = 0; fcn_i < fcn_numr.length; fcn_i++) {
		var fcn_c = fcn_numr.charAt(fcn_i);
		if (!fcDigitoNumerico(fcn_c)) {
			window.alert("Informar apenas valores numéricos.");
			campo.value = "";
			campo.focus();
			return false;
		}
	}

	return true;
}

function fcDigitoNumerico (fcn_digito) {
	return ( ( (fcn_digito >= "0") && (fcn_digito <= "9") ) || (fcn_digito == ",") || (fcn_digito == "."))
}

//Fonte: http://www.guj.com.br/java/33494-campo-cpf-validar
function validaCPF(cpf) {
	erro = new String;

	if (cpf.value.length == 11) {
		cpf.value = cpf.value.replace('.', '');
		cpf.value = cpf.value.replace('.', '');
		cpf.value = cpf.value.replace('-', '');

		var nonNumbers = /\D/;

		if (nonNumbers.test(cpf.value)) {
			erro = "A verificacao de CPF suporta apenas números!";
		} else {
			if (cpf.value == "00000000000" || cpf.value == "11111111111"
				|| cpf.value == "22222222222" || cpf.value == "33333333333"
					|| cpf.value == "44444444444" || cpf.value == "55555555555"
						|| cpf.value == "66666666666" || cpf.value == "77777777777"
							|| cpf.value == "88888888888" || cpf.value == "99999999999") {

				erro = "Número de CPF inválido!"
			}

			var a = [];
			var b = new Number;
			var c = 11;

			for (i = 0; i < 11; i++) {
				a[i] = cpf.value.charAt(i);
				if (i < 9)
					b += (a[i] * --c);
			}

			if ((x = b % 11) < 2) {
				a[9] = 0
			} else {
				a[9] = 11 - x
			}
			b = 0;
			c = 11;

			for (y = 0; y < 10; y++)
				b += (a[y] * c--);

			if ((x = b % 11) < 2) {
				a[10] = 0;
			} else {
				a[10] = 11 - x;
			}

			if ((cpf.value.charAt(9) != a[9])
					|| (cpf.value.charAt(10) != a[10])) {
				erro = "Número de CPF inválido.";
			}
		}
	} else {
		if (cpf.value.length == 0)
			return false
			else
				erro = "Número de CPF inválido.";
	}
	if (erro.length > 0) {
		alert(erro);
		cpf.focus();
		return false;
	}
	return true;
}

//envento onkeyup
function maskCPF(CPF) {
	if (CPF.value.length == 3) {
		CPF.value = CPF.value + '.';
	}
	if (CPF.value.length == 7) {
		CPF.value = CPF.value + '.';
	}
	if (CPF.value.length == 11) {
		CPF.value = CPF.value + '-';
	}
}

//evento onBlur
function formataCPF(CPF) {
	with (CPF) {
		value = value.substr(0, 3) + '.' + value.substr(3, 3) + '.'
		+ value.substr(6, 3) + '-' + value.substr(9, 2);
	}
}

function retiraFormatacao(CPF) {
	with (CPF) {
		value = value.replace(".", "");
		value = value.replace(".", "");
		value = value.replace("-", "");
		value = value.replace("/", "");
	}
}

VerifiqueTAB = true;
function fcSaltaTAB(quem, tammax) {
	var fcn_i = 0, fcn_j = 0, fcn_indice = -1;
	if ((quem.value.length == tammax) && (VerifiqueTAB)) {

		for (fcn_i = 0; fcn_i < document.forms.length; fcn_i++) {
			for (fcn_j = 0; fcn_j < document.forms[fcn_i].elements.length; fcn_j++) {
				if (document.forms[fcn_i].elements[fcn_j].name == quem.name) {
					fcn_indice = fcn_i;
					break;
				}
			}
			if (fcn_indice != -1)
				break;
		}
		for (fcn_i = 0; fcn_i <= document.forms[fcn_indice].elements.length; fcn_i++) {
			if (document.forms[fcn_indice].elements[fcn_i].name == quem.name) {
				while ((document.forms[fcn_indice].elements[(fcn_i + 1)].type == "hidden")
						&& (fcn_i < document.forms[fcn_indice].elements.length)) {
					fcn_i++;
				}
				document.forms[fcn_indice].elements[(fcn_i + 1)].focus();
				VerifiqueTAB = false;
				break;
			}
		}
	}
}

//envento onkeyup
function maskTelefone(telefone) {
	if (telefone.value.length == 0) {
		telefone.value = telefone.value + '(';
	}
	if (telefone.value.length == 3) {
		telefone.value = telefone.value + ')';
	}
	if (telefone.value.length == 8) {
		telefone.value = telefone.value + '-';
	}
}

//envento onkeyup
function maskData(data) {
	if (data.value.length == 2) {
		data.value = data.value + '/';
	}
	if (data.value.length == 5) {
		data.value = data.value + '/';
	}
}

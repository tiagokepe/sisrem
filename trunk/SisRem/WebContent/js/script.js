function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 0);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function soNumeros(v) {
	return v.replace(/\D/g, "");
}

function telefone(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/^(\d\d)(\d)/g, "($1)$2"); // Coloca parnteses em volta dos
												// dois primeiros dgitos
	v = v.replace(/(\d{4})(\d)/, "$1-$2"); // Coloca hfen entre o quarto e o
											// quinto dgitos
	return v;
}

function horario(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que n�o � n�mero
	v = v.replace(/(\d{2})(\d)/, "$1:$2"); // Coloca ':' entre o segundo e o// terceiro dgitos
	
	if (v.length == 5){ 
		situacao = ""; 
		hrs = (v.substring(0,2)); 
        min = (v.substring(3,5)); 
	    // verifica data e hora 
	    if ((hrs < 00 ) || (hrs > 23) || ( min < 00) ||( min > 59)){ 
	        situacao = "falsa"; 
	    } 
	     
	    if (v.value == "") { 
	        situacao = "falsa"; 
	    } 

	    if (situacao == "falsa") { 
	       v = "";
	    }  
    } 
	return v;
}


function cpf(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{3})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
											// e o quarto dgitos
	v = v.replace(/(\d{3})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
											// e o quarto dgitos
	v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2"); // Coloca um hfen entre o
													// terceiro e o quarto
													// dgitos
	return v;
}

function cep(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{5})(\d)/, "$1-$2");
	return v;
}

function digitoVerificador(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{7})(\d)/, "$1-$2");
	return v;
}

function idUnica(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{8})(\d)/, "$1-$2");
	return v;
}


function codigoCargo(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{3})(\d)/, "$1.$2");
	return v;
}

function tituloEleitor(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{10})(\d)/, "$1-$2");
	return v;
}

function cnpj(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/^(\d{2})(\d)/, "$1.$2"); // Coloca ponto entre o segundo e o
											// terceiro dgitos
	v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3"); // Coloca ponto entre o
														// quinto e o sexto
														// dgitos
	v = v.replace(/\.(\d{3})(\d)/, ".$1/$2"); // Coloca uma barra entre o
												// oitavo e o nono dgitos
	v = v.replace(/(\d{4})(\d)/, "$1-$2"); // Coloca um hfen depois do bloco de
											// quatro dgitos
	return v;
}

function moeda(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que n�o � d�gito
	v = v.replace(/(\d{2})$/, ".$1"); // Coloca o ponto
	v = v.replace(/^(0)(\d)/g, "$2");
	return v;
}

function moeda2(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que n�o � d�gito
	v = v.replace(/(\d{2})$/, ",$1"); // Coloca a virgula
	v = v.replace(/(\d+)(\d{3},\d{2})$/g, "$1.$2"); // Coloca o primeiro ponto
	var qtdLoop = (v.length - 3) / 3;
	var count = 0;
	while (qtdLoop > count) {
		count++;
		v = v.replace(/(\d+)(\d{3}.*)/, "$1.$2"); // Coloca o resto dos pontos
	}
	v = v.replace(/^(0)(\d)/g, "$2"); // Coloca h�fen entre o quarto e o
	return v;
}

function pis(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que no dgito
	v = v.replace(/(\d{3})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
											// e o quarto dgitos
	v = v.replace(/(\d{5})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
											// e o quarto dgitos
	v = v.replace(/(\d{2})(\d{1,2})$/, "$1-$2"); // Coloca um hfen entre o
													// terceiro e o quarto
													// dgitos
	return v;
}


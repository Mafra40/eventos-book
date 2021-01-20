//VALIDADOR DE FORMULÁRIOS

var FormValidation = function () {

    // basic validation
    var handleValidation1 = function() {
        // for more info visit the official plugin documentation: 
            // http://docs.jquery.com/Plugins/Validation

            var form1 = $('#form_sample_1');
            var error1 = $('.alert-danger', form1);
            var success1 = $('.alert-success', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                messages: {
                    select_multi: {
                        maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                        minlength: jQuery.validator.format("At least {0} items must be selected")
                    }
                },
                rules: {

                    senha: {
                        minlength: 5,
                        required: true
                    },
                    confirmSenha: {
                        minlength: 5,
                        required: true
                    },

                    nome: {
                        minlength: 2,
                        required: true
                    },
                    name: {
                        minlength: 2,
                        required: true
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    url: {
                        required: true,
                        url: true
                    },
                    number: {
                        required: true,
                        number: true
                    },
                    digits: {
                        required: true,
                        digits: true
                    },
                    creditcard: {
                        required: true,
                        creditcard: true
                    },
                    occupation: {
                        minlength: 5,
                    },
                    select: {
                        required: true
                    },
                    select_multi: {
                        required: true,
                        minlength: 1,
                        maxlength: 3
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    Metronic.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success1.show();
                    error1.hide();
                }
            });


    }

    // validation using icons
    var handleValidation2 = function() {

            var form2 = $('#form_sample_2');
            var error2 = $('.alert-danger', form2);
            var success2 = $('.alert-success', form2);

            form2.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                rules: {
                	
                	senha: {
                        minlength: 5,
                        required: true
                    },
                    senhaAtual: {
                        minlength: 5,
                        required: true
                    },
                    confirmSenha: {
                        minlength: 5,
                        required: true,
                        equalTo: "#senha"
                    },
                    nome: {
                        minlength: 2,
                        required: true
                    },

                    valorSelect: {
                        required: true
                    },

                    data: {
                        maxlength: 10,
                        minlength: 10,
                        required: true
                    },

                    hora: {
                        maxlength: 5,
                        minlength: 5,
                        required: true,
                        validaHorario:true
                    },
                    name: {
                        minlength: 2,
                        required: true
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    url: {
                        required: true,
                        url: true
                    },
                    number: {
                        required: true,
                        number: true
                    },
                    digits: {
                        required: true,
                        digits: true
                    },
                    creditcard: {
                        required: true,
                        creditcard: true
                    },
                },
                messages: { // custom messages for radio buttons and checkboxes
                    
                	senha: {
                        minlength: "Tamanho minimo 4.",
                        required: "Campo obrigatório."
                    },
                    senhaAtual: {
                        required: "Campo obrigatório."
                    },
                    confirmSenha: {
                        minlength: 5,
                        required: true,
                        equalTo: "As senhas estão diferentes"
                    }
                },
                
                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success2.hide();
                    error2.show();
                    Metronic.scrollTo(error2, -200);
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    var icon = $(element).parent('.input-icon').children('i');
                    icon.removeClass('fa-check').addClass("fa-warning");  
                    icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').removeClass("has-success").addClass('has-error'); // set error class to the control group   
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    
                },

                success: function (label, element) {
                    var icon = $(element).parent('.input-icon').children('i');
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
                    icon.removeClass("fa-warning").addClass("fa-check");
                },

                submitHandler: function (form) {
                    success2.show();
                    error2.hide();
                    form[0].submit(); // submit the form
                }
            });


    }
    
    //validações personalizadas.
    //@value = valor do campo atual.
    //@arg = argumento passado no validade.
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
    	  return arg != value;
    	 }, "Selecione um registro.");
    
    /** Só funciona se tiver campo com a classe .campo_horario
     * 
     */
    $.validator.addMethod("validaHorario", function(value, element, arg){
    	horario = value;
		var hora1 = horario.substr(0,2);
		var min1 = horario.substr(3,2);
		var hora2;
		var min2;	
		
		if( horario.length  <= 5){
			hora2 = "00";
			min2 = "00";
		}  else {
			hora2 = horario.substr(9,2);
			min2 = horario.substr(12,2);	
		}
		
		
		var isValido = true;
		
		if (hora1 > 23 || hora2 > 23){
			isValido = false;
		}
		
		if(min1 > 59 || min2 > 59){
			isValido = false;
		}
		
		if(horario.length > 5){
			if (horario.indexOf(" às ") == -1){
				isValido = false;
			}
		}
	
		return isValido == arg;
  	 }, "Formato de horário invalido.");
    
    
    $.validator.addMethod("documentoEmUso", function(value, element, arg){
    	return value == arg;
 	 }, "Documento em uso.");
   
    
    
    // advance validation
    var handleValidation3 = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

            var form3 = $('#form_sample_3');
            var error3 = $('.alert-danger', form3);
            var success3 = $('.alert-success', form3);

            //IMPORTANT: update CKEDITOR textarea with actual content before submit
            form3.on('submit', function() {
                for(var instanceName in CKEDITOR.instances) {
                    CKEDITOR.instances[instanceName].updateElement();
                }
            })

            form3.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: true, // do not focus the last invalid input
                ignore: "", // validate all fields including form hidden input
                rules: { 
                    nome: {
                        minlength: 4,
                        required: true
                    },
                    descricao: {
                       required: true
                    },
                    email: {
                        required: true,
                        email: true
                    },  
                    estado: {
                    	valueNotEquals: "0"
                    },
                    cidade: {
                    	valueNotEquals: "0"
                    },
                    categoria: {
                    	valueNotEquals: "0"
                    },
                    sexo: {
                    	valueNotEquals: "N"
                    },
                    horarioAtendimento: {
                    	validaHorario: true
                    },
                    logradouro: {
                    	 minlength: 4,
                    	 required: true
                    },
                    dataNascimento: {
                 	   required: true
                    },
                    CPF: {
                    	 required: true
                    },
                    numeroDocumento: {
                        required: true
                      },
                    isDocumentoEmUso: {
                   	 documentoEmUso: "false"
                   }
                    
                },

                messages: { // custom messages for radio buttons and checkboxes
                    
                    nome: {
                        minlength: "Tamanho minimo 4.",
                        required: "Campo obrigatório."
                    },
                    descricao: {
                        required: "Campo obrigatório."
                    },
                    categoria: {
                    	valueNotEquals: "Campo obrigatório."
                    },
                    service: {
                        required: "Please select  at least 2 types of Service",
                        minlength: jQuery.validator.format("Please select  at least {0} types of Service")
                    },
                    estado: {
                    	valueNotEquals: "Campo obrigatório." 
                    },
                    cidade: {
                    	valueNotEquals: "Campo obrigatório." 
                    },
                    sexo: {
                    	valueNotEquals: "Campo obrigatório." 
                    },
                    horarioAtendimento: {
                    	validaHorario: "Formato de horário invalido." 
                    },
                    logradouro: {
                    	 minlength: "Tamanho minimo 4.",
                         required: "Campo obrigatório."
                   },
                   dataNascimento: {
                	   required: "Campo obrigatório."
                   },
                   CPF: {
                    required: "Campo obrigatório."
                  },
                  numeroDocumento: {
                      required: "Campo obrigatório."
                    },
                  isDocumentoEmUso: {
                	  required: "Campo obrigatório."
                       }
                   
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    if (element.parent(".input-group").size() > 0) {
                        error.insertAfter(element.parent(".input-group"));
                    } else if (element.attr("data-error-container")) { 
                        error.appendTo(element.attr("data-error-container"));
                    } else if (element.parents('.radio-list').size() > 0) { 
                        error.appendTo(element.parents('.radio-list').attr("data-error-container"));
                    } else if (element.parents('.radio-inline').size() > 0) { 
                        error.appendTo(element.parents('.radio-inline').attr("data-error-container"));
                    } else if (element.parents('.checkbox-list').size() > 0) {
                        error.appendTo(element.parents('.checkbox-list').attr("data-error-container"));
                    } else if (element.parents('.checkbox-inline').size() > 0) { 
                        error.appendTo(element.parents('.checkbox-inline').attr("data-error-container"));
                    } else {
                    	
                        error.insertAfter(element); // for other inputs, just perform default behavior
                        error.appendTo(element.attr("data-error-container"));
                        
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit   
                    success3.hide();
                    error3.show();
                    Metronic.scrollTo(error3, -200);
                },

                highlight: function (element) { // hightlight error inputs
                   $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success3.show();
                    error3.hide();
                    form[0].submit(); // submit the form
                }

            });

             //apply validation on select2 dropdown value change, this only needed for chosen dropdown integration.
            $('.select2me', form3).change(function () {
                form3.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
            });

            // initialize select2 tags
            $("#select2_tags").change(function() {
                form3.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input 
            }).select2({
                tags: ["red", "green", "blue", "yellow", "pink"]
            });

            //initialize datepicker
            $('.date-picker').datepicker({
                rtl: Metronic.isRTL(),
                autoclose: true
            });
            $('.date-picker .form-control').change(function() {
                form3.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input 
            })
    }

    var handleWysihtml5 = function() {
        if (!jQuery().wysihtml5) {
            
            return;
        }

        if ($('.wysihtml5').size() > 0) {
            $('.wysihtml5').wysihtml5({
                "stylesheets": ["../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css"]
            });
        }
    }

    return {
        //main function to initiate the module
        init: function () {

            handleWysihtml5();
            handleValidation1();
            handleValidation2();
            handleValidation3();

        }

    };

}();
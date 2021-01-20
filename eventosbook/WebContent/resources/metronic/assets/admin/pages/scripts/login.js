var Login = function() {

    var handleLogin = function() {

        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
            	email: {
                    required: true
                },
            	senha: {
                    required: true
                },
                remember: {
                    required: false
                }
            },

            messages: {
            	email: {
            		required: "Digite um email."
                },
                senha: {
            		required: "Digite uma senha."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit(); // form validation success, call ajax form submit
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    $('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
    }

    var handleForgetPassword = function() {
        $('.forget-form-recuperarConta').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
                email: {
                    required: true,
                    email: true
                }
            },

            messages: {
                email: {
                    required: "Digite um email cadastrado.",
                    email: "Email inváido"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.forget-form-recuperarConta input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });

       

    }
    
    
    var handleRetrieveAccount = function() {
        $('.register-form-alterarSenha').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
                palavraPasse: {
                    required: true
                },
                senha: {
                    required: true
                },
                confirmSenha: {
                    equalTo: "#register_password",
                    required: true
                }
            },

            messages: {
                palavraPasse: {
                    required: "Digite a palavra passe."
                },
            
                 senha: {
                    required: "Insira uma nova senha"
                },
                confirmSenha: {
                    equalTo: "As senhas estão diferentes",
                    required: "Confirme sua senha."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.register-form-alterarSenha input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form-alterarSenha').validate().form()) {
                    $('.register-form-alterarSenha').submit();
                }
                return false;
            }
        });

       

    }

    var handleRegister = function() {

        function format(state) {
            if (!state.id) return state.text; // optgroup
            return "<img class='flag' src='../../assets/global/img/flags/" + state.id.toLowerCase() + ".png'/>&nbsp;&nbsp;" + state.text;
        }

        if (jQuery().select2) {
	        $("#select2_sample4").select2({
	            placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Select a Country',
	            allowClear: true,
	            formatResult: format,
	            formatSelection: format,
	            escapeMarkup: function(m) {
	                return m;
	            }
	        });


	        $('#select2_sample4').change(function() {
	            $('.register-form').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
	        });
	        
	        $('#select2_sample4').change(function() {
	            $('.register-form-contratante').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
	        });
	        
	        $('#select2_sample4').change(function() {
	            $('.register-form-fornecedor').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
	        });
    	}

        $('.register-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	
            	nome: {
                    required: true
                },

                fullname: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                address: {
                    required: true
                },
                city: {
                    required: true
                },
                country: {
                    required: true
                },

                username: {
                    required: true
                },
                password: {
                    required: true
                },
                rpassword: {
                    equalTo: "#register_password"
                },
                
                senha: {
                    required: true
                },
                confirmSenha: {
                    equalTo: "#register_password"
                },


                tnc: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
                nome: {
                    required: "Informe seu nome completo."
                },
            
	            email: {
	                required: "Informe seu email."
	            },
                
                senha: {
	                required: "Informe uma senha."
	            },
                
	            confirmSenha: {
	            	equalTo:"As Senhas estão diferentes",
	                required: "Confirme sua senha."
	            }
                
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.register-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form').validate().form()) {
                    $('.register-form').submit();
                }
                return false;
            }
        });
        
        
        $('.register-form-contratante').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	
            	nome: {
                    required: true
                },
                
                email: {
                    required: true,
                    email: true
                },
  
                senha: {
                    required: true
                },
                confirmSenha: {
                    equalTo: "#register_password",
                    required: true
                },


                tnc: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
                nome: {
                    required: "Informe seu nome completo."
                },
            
	            email: {
	                required: "Informe seu email.",
	                email: "Informe um email válido"	
	            },
                
                senha: {
	                required: "Informe uma senha."
	            },
                
	            confirmSenha: {
	            	equalTo:"As Senhas estão diferentes",
	                required: "Confirme sua senha."
	            }
                
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.register-form-contratante input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form-contratante').validate().form()) {
                    $('.register-form-contratante').submit();
                }
                return false;
            }
        });
        
        $('.register-form-fornecedor').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	
            	nome: {
                    required: true
                },
                
                numeroDocumento: {
                    required: true
                },

                email: {
                    required: true,
                    email: true
                },
                
                valorSelect: {
                    required: true,
                },
                
                senha: {
                    required: true
                },
                confirmSenha: {
                    equalTo: "#register_password",
                    required: true
                },
                
                tnc: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
                nome: {
                    required: "Informe o nome da empresa."
                },
            
                numeroDocumento: {
                    required: "Informe o Número do Documento - (CPF: para Pessoa Física, CNPJ ou IE para Pessoa Jurídica)"
                },
	            email: {
	                required: "Informe seu email."
	            },
	            
	            valorSelect: {
                    required: "Informe sua área de atuação",
                },
                
                senha: {
	                required: "Informe uma senha."
	            },
                
	            confirmSenha: {
	            	equalTo:"As Senhas estão diferentes",
	                required: "Confirme sua senha."
	            }
                
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },


            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.register-form-fornecedor input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form-fornecedor').validate().form()) {
                    $('.register-form-fornecedor').submit();
                }
                return false;
            }
        });

        
        jQuery('#register-back-btn-contratante').click(function(){
        	history.back()
        });
        
        jQuery('#register-back-btn-fornecedor').click(function(){
        	history.back()
        });
        
         jQuery('#back-btn-recuperarConta').click(function(){
        	history.back()
        });
    }

    return {
        //main function to initiate the module
        init: function() {

            handleLogin();
            handleForgetPassword();
            handleRegister();
            handleRetrieveAccount();

        }

    };

}();
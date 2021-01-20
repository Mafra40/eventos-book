var FormFileUpload = function () {


    return {
        //inicialzia 
        init: function () {

            
        	
            $('#fileupload').fileupload({
                disableImageResize: false,
                autoUpload: false,
                disableImageResize: /Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),
                maxFileSize: 3000000,
                acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                     
                dataType: 'json',
                
                done: function (e, data) {
                		$(".barra").removeClass( "progress-bar progress-bar-success" );
                		$(".barra").text("Enviado");
                },
            });

          

       
        }

    };

}();
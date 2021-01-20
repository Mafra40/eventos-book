


//Configura para deixar pesquenas imagens selecionavel
function configThumnailImagens(){
	
	
	$('.owl-page').append('<img src=""/>'); //add componente img
	$('.owl-page span').remove(); //remove o span padrão do corousel.
	var slider = $('.owl-page');
	
	
	//percorre a cada quantidade de fotos
	$.each(this.owl.userItems, function(index, value ){
		
		//pega a url das imagens grande.
		var src = $("#img"+index).attr('src');
		
		slider[index].children[0].src = src;
        $(slider[index]).last().attr("src", src);
    });
 }
 


//execulta quando a página carregar.
$( document ).ready(function() {
	
	
	$("#owl-fornecedor-img").owlCarousel({
		
		//Autoplay
	    autoPlay : true,
	    stopOnHover : true,
	    navigationText : ["<",">"],
		navigation : false, // Botão Next
	    slideSpeed : 300,
	    responsive: true,
	    responsiveRefreshRate : 200,
	    responsiveBaseWidth: window,
	    paginationSpeed : 400,
	    singleItem:true,
	    autoHeight : false,
	    afterInit: configThumnailImagens,
	    width: 900
		
	});
	
});
 



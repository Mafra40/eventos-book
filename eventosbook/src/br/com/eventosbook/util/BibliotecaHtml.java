package br.com.eventosbook.util;

import java.util.ArrayList;
import java.util.List;

import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarAvaliacaoComentFornecedor;

public class BibliotecaHtml {

	private static BibliotecaHtml aBibliotecaHtml = new BibliotecaHtml();

	public static BibliotecaHtml getInstance(){
		if(BibliotecaHtml.aBibliotecaHtml == null){
			BibliotecaHtml.aBibliotecaHtml = new BibliotecaHtml();
		}

		return BibliotecaHtml.aBibliotecaHtml;
	}


	//ESTE MÉTODO DEVE SER INSERIDO NUMA REGRA DE CRIAÇÃO DE VIEW
	/**Método que monta o corpo das páginas de comentário. Criado devido ao bug quando o browser monta as TAGS.
	 * 
	 * @param pListComentario
	 * @return
	 */
	public ArrayList<String> montarSessaoComentarios(List<FiltroConsultarAvaliacaoComentFornecedor> pListComentario, boolean pSeparador){
		StringBuilder header = new StringBuilder();
		StringBuilder footer = new StringBuilder();
		StringBuilder corpoComentario = new StringBuilder();
		StringBuilder comentario =new StringBuilder();
		StringBuilder nota =new StringBuilder();
		String divSeparador = "";
		Double notaComentario = 0.0;

		boolean isHeaderCriado = false;
		boolean criarFooter = false;
		boolean isCompleto = false;
		boolean naoExisteProximo = false;
		boolean isAvaliado = false;



		//coloca a separação da div.
		if (pSeparador){
			divSeparador = "<div class='col-md-2'></div>";
		}

		ArrayList<String> comentarios = new ArrayList<String>();
		int tamanho = pListComentario.size()-1;
		for (int i = 0; i < pListComentario.size(); i++) {

			//testa se o proximo id de avaliação é igual ao atual.
			if(i+1 > tamanho){
				naoExisteProximo = true;
			}

			if (naoExisteProximo){criarFooter = true;}

			if (criarFooter == false){
				if ((pListComentario.get(i+1).getCdAvaliacao() != pListComentario.get(i).getCdAvaliacao())  ) {
					criarFooter = true;
				}
			}

			//monta o header;.
			if (isHeaderCriado == false){

				header.append(divSeparador+
						"<div class='col-md-10' >"
						+"<div class='portlet light bordered'>"+
						"<div class='portlet-title'>"+
						"<div class='caption font-blue'>"
						+"<i class='icon-speech font'></i>"+
						"<span class='caption-subject bold font-black uppercase'> "+ pListComentario.get(i).getNomeContratante() +" </span>"+
						"<span class='caption-helper'> "+BibliotecaFuncao.getDataComoString(pListComentario.get(i).getDataAvaliacao()) +" </span>"+
						"</div>"+
						"<div class='actions'>"+
						"" +
						"</div>"+
						"</div>"+
						"<div class='portlet-body'>"+
						"<div>");

				notaComentario =  pListComentario.get(i).getNota();


				if (isAvaliado == false) {
					for (int j = 1; j <= notaComentario.intValue() ; j++) {
						//Define a qtd de estrelas

						if((notaComentario.compareTo(new Double(1.0)) >= 0  && notaComentario.compareTo(new Double(1.55)) <= 0) && isAvaliado == false){
							nota.append("<h4 class='font-black bold '>Horrível ");
							isAvaliado = true;
						}
						if((notaComentario.compareTo(new Double(1.56)) >= 0  && notaComentario.compareTo(new Double(2.55)) <= 0) && isAvaliado == false){
							nota.append("<h4 class='font-black bold '>Ruim ");
							isAvaliado = true;
						}
						if((notaComentario.compareTo(new Double(2.56)) >= 0  && notaComentario.compareTo(new Double(3.55)) <= 0) && isAvaliado == false){
							nota.append("<h4 class='font-black bold '>Razoável ");
							isAvaliado = true;
						}
						if((notaComentario.compareTo(new Double(3.56)) >= 0  && notaComentario.compareTo(new Double(4.55)) <= 0) && isAvaliado == false){
							nota.append("<h4 class='font-black bold '>Bom ");
							isAvaliado = true;
						}
						if((notaComentario.compareTo(new Double(4.56)) >= 0  && notaComentario.compareTo(new Double(5)) <= 0) && isAvaliado == false){
							nota.append("<h4 class='font-black bold '>Exelente ");
							isAvaliado = true;
						}
						nota.append("<i class='fa fa-star font-yellow'></i> ");
					}
					nota.append("</h4><br/>");
				}

				header.append(nota);
				comentario.append(header);
				isHeaderCriado = true;
			}

			//monta o corpo dos comentários
			if(pListComentario.get(i).getTipoComentario() == 2){
				corpoComentario.append("<p>"+
						"<i class='fa fa-plus-circle font-red'></i>"+pListComentario.get(i).getDescricao()+
						"</p>");
			}

			if(pListComentario.get(i).getTipoComentario() == 1){
				corpoComentario.append(
						"<p>"+
								"<i class='fa fa-minus-circle font-green'></i>"+pListComentario.get(i).getDescricao()+
						"</p>");
			}


			//montar o footer caso toda parte do header e o corpo do comentário esteja criado.
			if (criarFooter){
				comentario.append(corpoComentario.toString());
				footer.append("</div></div></div></div>");
				comentario.append(footer);
				comentarios.add(comentario.toString());
				isCompleto = true;
			}


			if (isCompleto){
				isCompleto = false;
				isHeaderCriado = false;
				criarFooter = false;
				isAvaliado = false;
				corpoComentario.setLength(0);
				comentario.setLength(0);
				footer.setLength(0);
				header.setLength(0);
				nota.setLength(0);
			}


		}
		//Adiciona a quatidade total de avaliçaões na ultima posição do array que deve ser removida ao exibir na tela
		
		return comentarios;
	}
	
	/**Método que retorna a nota final com as estrelas de cada fornecedor.
	 * 
	 * @param pNotaFinal
	 * @return
	 */
	public String getAvaliacao(Double pNotaFinal){
		StringBuilder nota =new StringBuilder();
		String cssClass = "font-blue blue-chambray";
		boolean isAvaliado = false;
		
		for (int j = 1; j <= pNotaFinal.intValue() ; j++) {
			//Define a qtd de estrelas

			if((pNotaFinal.compareTo(new Double(1.0)) >= 0  && pNotaFinal.compareTo(new Double(1.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Horrível ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(1.56)) >= 0  && pNotaFinal.compareTo(new Double(2.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Ruim ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(2.56)) >= 0  && pNotaFinal.compareTo(new Double(3.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Razoável ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(3.56)) >= 0  && pNotaFinal.compareTo(new Double(4.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Bom ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(4.56)) >= 0  && pNotaFinal.compareTo(new Double(5)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Exelente ");
				isAvaliado = true;
			}
			nota.append("<i class='fa fa-star font-yellow'></i> ");
		}
		nota.append("</h4>");
		return nota.toString();
	}
	
	/**
	 * 
	 * @param pNotaFinal
	 * @return
	 */
	public String getAvaliacaoSemEstrelas(Double pNotaFinal){
		StringBuilder nota =new StringBuilder();
		String cssClass = "font-blue blue-chambray";
		boolean isAvaliado = false;
		
		

			if((pNotaFinal.compareTo(new Double(1.0)) >= 0  && pNotaFinal.compareTo(new Double(1.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Horrível ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(1.56)) >= 0  && pNotaFinal.compareTo(new Double(2.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Ruim ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(2.56)) >= 0  && pNotaFinal.compareTo(new Double(3.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Razoável ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(3.56)) >= 0  && pNotaFinal.compareTo(new Double(4.55)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Bom ");
				isAvaliado = true;
			}
			if((pNotaFinal.compareTo(new Double(4.56)) >= 0  && pNotaFinal.compareTo(new Double(5)) <= 0) && isAvaliado == false){
				nota.append("<h4 class='"+cssClass+"'>Exelente ");
				isAvaliado = true;
			}
		
		nota.append("</h4>");
		return nota.toString();
	}
	
	/**
	 * 
	 * @param pNotaFinal
	 * @return
	 */
	public String getQtdEstrelas(Double pNotaFinal){
		StringBuilder estrela =new StringBuilder();
		String cssClass = "fa fa-star font-yellow";
		
		for (int j = 1; j <= pNotaFinal.intValue() ; j++) {
			estrela.append("<i class='"+cssClass+"'></i> ");
		}
		return estrela.toString();
	}
	
	
}

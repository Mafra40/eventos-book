	<!-- BEGIN SIDEBAR -->
<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_HOME_CONTRATANTE)%>">
					<i class="icon-home"></i>
					<span class="title">Home</span>
					</a>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-settings"></i>
					<span class="title">Meu Perfil</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_ALTERACAO_CONTRATANTE)%>">
							<i class="icon-refresh"></i>
							Alterar Perfil</a>
						</li>
						<li>
							<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_ALTERACAO_SENHAS_USUARIOS)%>">
							<i class="icon-lock"></i>
							Alterar Senha</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_MEU_EVENTO)%>">
					<i class="icon-calendar"></i>
					<span class="title">Meus Eventos</span>
					</a>
				</li>

				<li class="">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_EXIBIR_MEUS_FORNECEDORES)%>">
					<i class="icon-badge"></i>
					<span class="title">Meus Fornecedores</span>
					</a>
				</li>

				<li class="">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_ORCAMENTO_CONTROLADOR, Constantes.LINK_EXIBIR_ORCAMENTO)%>">
					<i class="glyphicon glyphicon-usd"></i>
					<span class="title">Meus Orçamentos</span>
					</a>
				</li>

				<li class="">
					<a href=" /<%=Constantes.LINK_SAIR%>">
					<i class="icon-logout"></i>
					<span class="title">Sair</span>
					</a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
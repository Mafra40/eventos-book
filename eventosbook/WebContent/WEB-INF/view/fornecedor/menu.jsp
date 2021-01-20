	<!-- BEGIN SIDEBAR -->
	<%@page import="br.com.eventosbook.constante.Constantes"%>
	<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_HOME_FORNECEDOR)%>">
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
							<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_ALTERACAO_FORNECEDOR)%>">
							<i class="icon-user"></i>
							Alterar Perfil</a>
						</li>
						<li>
							<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_ALTERACAO_SENHAS_USUARIOS)%>">
							<i class="icon-lock"></i>
							Alterar Senha</a>
						</li>
						
						<li>
							<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS)%>">
							<i class="icon-picture"></i>
							Upload de Imagens</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href= "/<%=Constantes.LINK_SAIR%>">
					<i class="icon-logout"></i>
					<span class="title">Sair</span>
					</a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
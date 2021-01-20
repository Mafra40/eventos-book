	<!-- BEGIN SIDEBAR -->
	<%@page import="br.com.eventosbook.constante.Constantes"%>
<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
			<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
			<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
			<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="">
					<a href="<%=Constantes.LINK_HOME_PRODUTOR%>">
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
							<a href="">
							<i class="icon-refresh"></i>
							Alterar Perfil</a>
						</li>
						<li>
							<a href="<%=Constantes.LINK_ALTERACAO_SENHAS_USUARIOS%>">
							<i class="icon-lock"></i>
							Alterar Senha</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="">
					<i class="icon-users"></i>
					<span class="title">Meus Contratantes</span>
					</a>
				</li>

				<li class="">
					<a href="">
					<i class="icon-users"></i>
					<span class="title">Meus Fornecedores</span>
					</a>
				</li>

				<li class="">
					<a href="">
					<i class="glyphicon glyphicon-usd"></i>
					<span class="title">Meus Orçamentos</span>
					</a>
				</li>

				<li class="">
					<a href="<%=Constantes.LINK_SAIR%>">
					<i class="icon-logout"></i>
					<span class="title">Sair</span>
					</a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
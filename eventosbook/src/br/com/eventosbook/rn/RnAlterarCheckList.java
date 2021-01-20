package br.com.eventosbook.rn;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoCheckListImpl;
import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnAlterarCheckList {
	
	private RnAlterarCheckList() {}

	private static RnAlterarCheckList aRnAlterarCheckList = new RnAlterarCheckList();

	public static RnAlterarCheckList getInstance(){
		if(RnAlterarCheckList.aRnAlterarCheckList == null){
			RnAlterarCheckList.aRnAlterarCheckList = new RnAlterarCheckList();
		}

		return RnAlterarCheckList.aRnAlterarCheckList;
	}
	
	
	public String executar(Integer id){
		CheckList checkList = new CheckList();
		checkList.setCodigo(id);
		checkList = DaoCheckListImpl.getInstance().getCheckList(checkList);
		
		if(checkList.getStatus().equals(Constantes.SIGLA_ATIVO)){
			checkList.setStatus(Constantes.SIGLA_INATIVO);
		} else {
			checkList.setStatus(Constantes.SIGLA_ATIVO);
		}
		
		DaoCheckListImpl.getInstance().alterar(checkList);
		
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CHECKLIST)+"?id="+checkList.getEvento().getCodigo();
	}
	

}

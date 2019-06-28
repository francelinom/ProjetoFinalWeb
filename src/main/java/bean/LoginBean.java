package bean;

import dao.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuario;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

    private Usuario usuarioAtual;

    public LoginBean() {
        usuarioAtual = new Usuario();
    }

    public String autentica() {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.listAll();

        for (Usuario i : usuarios) {
            if (i.getLogin().equals(usuarioAtual.getLogin())) {
                if (i.getSenha().equals(usuarioAtual.getSenha())) {
                    if(i.getAdmin() == true){
                    ExternalContext ec = context.getExternalContext();
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("admin-logado", i);
                    return "/admin/BemVindo?faces-redirect=true";
                } else {
                    ExternalContext ec = context.getExternalContext();
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("usuario-logado", i);
                    return "/user/BemVindo?faces-redirect=true";
                    }
                }
            }
        }

        System.out.println("Usuario não encontrado");
        FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, mensagem);
        return null;

    }
    
    public String sair(){
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext ec = context.getExternalContext();
			HttpSession s = (HttpSession) ec.getSession(true);
			s.invalidate();
			return "/index?faces-redirect=true";
	}

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

}

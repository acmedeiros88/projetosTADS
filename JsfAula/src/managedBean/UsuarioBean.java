package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UsuarioDao;
import entity.Usuario;

@Named(value="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 4564911835806007407L;
	private String nome;
	private String senha;
	
	private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();
	
	@Inject
    private UsuarioDao usuarioManager;
    
	
	public UsuarioBean() {

	}
	
	public String goPagePrint() {
		return "printUsuario";
	}
	
	public String goPageHibernate() {
		return "usuarioHibernate";
	}
	
	public String goPage1() {
		return "usuario";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

    @PostConstruct
    public void init() {
        this.usuarios = usuarioManager.loadAllusuarios();
    }
    
    public void delete(Usuario usuario) {
        usuarioManager.delete(usuario);
        usuarios.remove(usuario);
    }
    
    public void add() {
        usuarioManager.adicionarUsuario(usuario);
        this.usuarios = usuarioManager.loadAllusuarios();
        this.usuario = new Usuario();
    }
    
    public void update() {
        usuarioManager.atulaizar(usuarios);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Dados atuliados"," Com sucesso!!") );
    }
    
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioDao getUsuarioManager() {
		return usuarioManager;
	}
	
	public void setUsuarioManager(UsuarioDao usuarioManager) {
		this.usuarioManager = usuarioManager;
	}
	
}

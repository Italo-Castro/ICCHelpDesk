package com.icchelpdesk.cliente.model.bean;

/**
 *
 * @author Italo
 */
public class Cliente {
    
    
    private int id;
    private String cnpj;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String tel_1;
    private String tel_2;
    private int enderecoId;
    private String responsavel;
    private int nfe,nfce,mdfe,cte;
    private String informacoes;
    private int menut,menuped,menuefd,menucx,mercurio,edsys;

    public Cliente() {
    }

    public Cliente(int id, String cnpj, String nomeEmpresarial, String nomeFantasia, String tel_1, String tel_2, int enderecoId, String responsavel, int nfe, int nfce, int mdfe, int cte, String informacoes, int menut, int menuped, int menuefd, int menucx, int mercurio, int edsys) {
        this.id = id;
        this.cnpj = cnpj;
        this.nomeEmpresarial = nomeEmpresarial;
        this.nomeFantasia = nomeFantasia;
        this.tel_1 = tel_1;
        this.tel_2 = tel_2;
        this.enderecoId = enderecoId;
        this.responsavel = responsavel;
        this.nfe = nfe;
        this.nfce = nfce;
        this.mdfe = mdfe;
        this.cte = cte;
        this.informacoes = informacoes;
        this.menut = menut;
        this.menuped = menuped;
        this.menuefd = menuefd;
        this.menucx = menucx;
        this.mercurio = mercurio;
        this.edsys = edsys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTel_1() {
        return tel_1;
    }

    public void setTel_1(String tel_1) {
        this.tel_1 = tel_1;
    }

    public String getTel_2() {
        return tel_2;
    }

    public void setTel_2(String tel_2) {
        this.tel_2 = tel_2;
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getNfe() {
        return nfe;
    }

    public void setNfe(int nfe) {
        this.nfe = nfe;
    }

    public int getNfce() {
        return nfce;
    }

    public void setNfce(int nfce) {
        this.nfce = nfce;
    }

    public int getMdfe() {
        return mdfe;
    }

    public void setMdfe(int mdfe) {
        this.mdfe = mdfe;
    }

    public int getCte() {
        return cte;
    }

    public void setCte(int cte) {
        this.cte = cte;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public int getMenut() {
        return menut;
    }

    public void setMenut(int menut) {
        this.menut = menut;
    }

    public int getMenuped() {
        return menuped;
    }

    public void setMenuped(int menuped) {
        this.menuped = menuped;
    }

    public int getMenuefd() {
        return menuefd;
    }

    public void setMenuefd(int menuefd) {
        this.menuefd = menuefd;
    }

    public int getMenucx() {
        return menucx;
    }

    public void setMenucx(int menucx) {
        this.menucx = menucx;
    }

    public int getMercurio() {
        return mercurio;
    }

    public void setMercurio(int mercurio) {
        this.mercurio = mercurio;
    }

    public int getEdsys() {
        return edsys;
    }

    public void setEdsys(int edsys) {
        this.edsys = edsys;
    }
    
    
    


}

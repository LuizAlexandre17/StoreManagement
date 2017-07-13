package br.com.secharpe.dao;

import br.com.secharpe.exception.SistemaException;
import br.com.secharpe.model.Cidades;
import br.com.secharpe.model.Empresa;
import br.com.secharpe.model.Estados;
import br.com.secharpe.util.Log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para acesso ao banco da Empresa
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class EmpresaDAO {

    private Log log = new Log();

    public void update(Empresa empresa) throws SistemaException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            ps = conn.prepareStatement("UPDATE EMPRESA SET NOME_EMPRESARIAL = ?, NOME_FANTASIA = ?, CNPJ = ?, LOGRADOURO = ?, BAIRRO = ?, CIDADE = ?, NUMERO = ?, COMPLEMENTO = ?, SITE = ?, EMAIL = ?, TELEFONE = ?, DATA_UPDATE = NOW() WHERE ID = 1");

            ps.setString(1, empresa.getNomeEmpresarial());
            ps.setString(2, empresa.getNomeFantasia());
            ps.setLong(3, (empresa.getCNPJ()));
            ps.setString(4, empresa.getLogradouro());
            ps.setString(5, empresa.getBairro());
            ps.setInt(6, empresa.getCidade().getCodigo());
            ps.setInt(7, empresa.getNumero());
            ps.setString(8, empresa.getComplemento());
            ps.setString(9, empresa.getSite());
            ps.setString(10, empresa.getEmail());
            ps.setLong(11, empresa.getTelefone());

            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    log.put("EmpresaDAO", "update", 0, ex.getMessage());
                    throw new SistemaException(ex.getMessage());
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.put("EmpresaDAO", "update", 1, ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.put("EmpresaDAO", "update", 2, ex.getMessage());
                }
            }
        }
    }

    public Empresa getAll() throws SistemaException {
        Empresa empresa = new Empresa();
        Cidades c = new Cidades();
        Estados es = new Estados();
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            ps = conn.prepareStatement("select nome_empresarial,nome_fantasia,cnpj,logradouro,bairro,complemento,site, email, telefone, cidade from empresa"); //s.nome from empresa inner join cidades on cidade=cidades.id");

            ResultSet rs = ps.executeQuery();
            rs.next();
            empresa.setNomeEmpresarial(rs.getString(1));
            empresa.setNomeFantasia(rs.getString(2));
            empresa.setCNPJ(rs.getLong(3));
            empresa.setLogradouro(rs.getString(4));
            empresa.setBairro(rs.getString(5));
            empresa.setComplemento(rs.getString(6));
            empresa.setSite(rs.getString(7));
            empresa.setEmail(rs.getString(8));
            empresa.setTelefone(rs.getLong(9));
            Cidades cidade = new Cidades();
            CidadeDAO cd = new CidadeDAO();
            cidade = cd.getCidade(rs.getInt(10));
            empresa.setCidade(cidade);

        } catch (SQLException e) {
            log.put("EmpresaDAO", "getEmpresa", 0, e.getMessage());
            throw new SistemaException(e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.put("EmpresaDAO", "getEmpresa", 1, ex.getMessage());
                    throw new SistemaException(ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.put("EmpresaDAO", "getEmpresa", 2, ex.getMessage());
                    throw new SistemaException(ex.getMessage());
                }
            }
        }
        return empresa;
    }
}

package br.com.secharpe.dao;

import br.com.secharpe.model.Produtos;
import br.com.secharpe.model.Unidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.secharpe.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* Classe para acesso ao banco de Produtos
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ProdutoDAO {

    private Log log = new Log();

    public void delete(int id) {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            String sql = "delete from produtos where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            log.put("ControleProdutoBanco", "delete", exceptionAsString);

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "delete", exceptionAsString);
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void insert(Produtos produto) {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        Date data = new java.sql.Date(new java.util.Date().getTime());

        try {
            conn = Connection.getConnection();
            String sql = "insert into produtos (nome,descricao,estoque,estoque_min,tipo,fabricante,id_unidade,preco_custo,preco_final,data_registro) values(?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getEstoque());
            ps.setInt(4, produto.getEstoqueMin());
            ps.setString(5, produto.getTipo());
            ps.setString(6, produto.getFabricante());
            ps.setInt(7, produto.getUnidade().getCodigo());
            ps.setFloat(8, produto.getCusto());
            ps.setFloat(9, produto.getValorVenda());
            ps.setDate(10, data);

            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            log.put("ControleProdutoBanco", "insert", exceptionAsString);

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    ex.printStackTrace(new PrintWriter(sw));
                    exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "update", exceptionAsString);
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void update(Produtos p) {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            String sql = "update produtos set nome=?,descricao=?,estoque=?,estoque_min=?,tipo=?,fabricante=?,id_unidade=?,preco_custo=?,preco_final=?,data_registro=now() where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setInt(3, p.getEstoque());
            ps.setInt(4, p.getEstoqueMin());
            ps.setString(5, p.getTipo());
            ps.setString(6, p.getFabricante());
            ps.setInt(7, p.getUnidade().getCodigo());
            ps.setFloat(8, p.getCusto());
            ps.setFloat(9, p.getValorVenda());
            ps.setInt(10, p.getCodigo());

            ps.setInt(2, p.getCodigo());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            log.put("ControleProdutoBanco", "update", exceptionAsString);

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "update", exceptionAsString);
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "update", exceptionAsString);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "update", exceptionAsString);
                }
            }
        }
    }

    public List<Produtos> getAll() {
        List<Produtos> lista = new ArrayList<Produtos>();
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            String sql = "select id, nome, descricao, estoque, estoque_min, preco_custo, preco_final, tipo, fabricante, id_unidade from produtos";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Produtos p = new Produtos();

                p.setCodigo(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescricao(rs.getString(3));
                p.setEstoque(rs.getInt(4));
                p.setEstoqueMin(rs.getInt(5));
                p.setCusto(rs.getFloat(6));
                p.setValorVenda(rs.getFloat(7));
                p.setTipo(rs.getString(8));
                p.setFabricante(rs.getString(9));
                UnidadeDAO u = new UnidadeDAO();
                p.setUnidade(u.getUnidade(rs.getInt(10)));

                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            log.put("ControleProdutoBanco", "ge tAll", exceptionAsString);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "getAll", exceptionAsString);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();
                    log.put("ControleProdutoBanco", "getAll", exceptionAsString);
                }
            }
        }
        return lista;
    }

    public Produtos getProduto(Integer codigo) {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connection.getConnection();
            String sql = "select nome, descricao, estoque, estoque_min, preco_custo, preco_final, tipo, fabricante, id_unidade from produtos where id= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Produtos p = new Produtos();
                p.setCodigo(codigo);
                p.setNome(rs.getString(1));
                p.setDescricao(rs.getString(2));
                p.setEstoque(rs.getInt(3));
                p.setEstoqueMin(rs.getInt(4));
                p.setCusto(rs.getFloat(5));
                p.setValorVenda(rs.getFloat(6));
                p.setTipo(rs.getString(7));
                p.setFabricante(rs.getString(8));

                UnidadeDAO u = new UnidadeDAO();

                p.setUnidade(u.getUnidade(rs.getInt(9)));

                return p;
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return null;
    }

}

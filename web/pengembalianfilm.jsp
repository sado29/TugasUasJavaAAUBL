<%@page import="java.sql.*" %>
<%@page import="com.film.koneksi.Koneksi" %>
<style type="text/css">
    .main {
        margin-top: 5px;
        margin-left: 10px;
        margin-right: 10px;
        margin-bottom: 10px;
    }
    div.ui-datepicker{
        font-size:12px;
    }
    
</style>

<link href="JQuery/smoothness/jquery-ui-1.10.3.custom.css" rel="stylesheet">

<script src="JQuery/jquery-1.9.1.js"></script>
<script src="JQuery/jquery-ui-1.10.3.custom.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
	  
        $("#tglkembali").datepicker({
            showOn: "both", buttonImage: "Gambar/calendar.png", buttonImageOnly: true, changeMonth: true, changeYear: true, dateFormat: "yy-mm-dd"}); 
	  			  
        function cari_customer(){
            var kodecustomer=$("#kodeCustomer").val();
            if(kodecustomer!=""){
                $.ajax({
                    type:"post",
                    url:"cari_data.jsp",
                    data:"kodecustomer="+kodecustomer,
                    success:function(data){
                        $("#namaCustomer").val(data)
                    }
                });
            }                                   
        }  			
			
        function cari_film(){
            var kodefilm=$("#kodeFilm").val();
            if(kodefilm!=""){
                $.ajax({
                    type:"post",
                    url:"cari_data.jsp",
                    data:"kodefilm="+kodefilm,
                    success:function(data){
                        $("#judulFilm").val(data)
                    }
                });
            }                                   
        }  
				  
        $('#kodeCustomer').change(function() {
            cari_customer();
            $('#tglkembali').focus()
        });				    
			                           
        $('#kodeFilm').change(function() {
            cari_film();
            $('#jmltxt').focus()
        });	
			  			  	
    });		

</script>



<div class="main">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
        <th align="left" scope="col"><font color="#000000" size="3" face="Tahoma, Geneva, sans-serif">DATA TRANSAKSI PENGEMBALIAN FILM</font></th>
        </tr>
        <tr>
        <td><hr /></td>
        </tr>
        <tr>
        <td>
            <form id="form1" name="form1" method="post" action="PengembalianController">
                <table width="400" border="0" align="left">
                    <tr>
                    <td width="40%" align="left" valign="middle">Kode Penyewaan</td>
                    <td width="2%" align="left" valign="middle">:</td>
                    <td width="68%" align="left" valign="top">
                        <input name="kodePenyewaan" type="text" id="kodePenyewaan" size="5" maxlength="5" value="${kodePenyewaan}" />
                        <input type="submit" name="cari" value="Cari"  />
                    </td>
                    </tr>
                    <tr>
                    <td align="left" valign="middle">&nbsp;</td>
                    <td align="left" valign="middle">&nbsp;</td>
                    <td align="left" valign="top"><hr /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="middle">Kode Customer</td>
                    <td align="left" valign="middle">:</td>
                    <td align="left" valign="top"><input name="kodeCustomer" type="text" id="kodeCustomer" size="5" maxlength="5" value="${kodeCustomer}" /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="middle">Nama Customer</td>
                    <td align="left" valign="middle">:</td>
                    <td align="left" valign="top"><input name="namaCustomer" type="text" id="namaCustomer" size="35" maxlength="35" readonly="readonly" /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top"><hr /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">Kode Film</td>
                    <td align="left" valign="top">:</td>
                    <td align="left" valign="top"><input name="kodeFilm" type="text" id="kodeFilm" size="5" maxlength="5" value="${kodeFilm}" /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">Judul Film</td>
                    <td align="left" valign="top">:</td>
                    <td align="left" valign="top"><input name="judulFilm" type="text" id="judulFilm" size="35" maxlength="35" readonly="readonly" /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top"><hr /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">Tgl Kembali</td>
                    <td align="left" valign="top">:</td>
                    <td align="left" valign="middle">
                        <input name="tglkembali" type="text" id="tglkembali" value="" size="10" maxlength="10" readonly="readonly" />
                    </td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">&nbsp;</td>
                    </tr>
                    <tr>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">&nbsp;</td>
                    <td align="left" valign="top">
                        <input type="submit" name="Simpan" value="Simpan" />
                    </td>
                    </tr>
                </table>
             
                <table width="700" border="0" align="center" cellpadding="4" cellspacing="1">
                    <tr>
                    <td colspan="6" align="right" valign="middle" scope="col"><font color="#000000" face="Tahoma, Geneva, sans-serif" size="2"></font></td>
                    </tr>
                    <tr>
                    <th width="10%" align="left" scope="col" bgcolor="#235996"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Kode</font></th>
                    <th width="22%" align="left" scope="col" bgcolor="#235996"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Nama Customer</font></th>
                    <th width="22%" align="left" scope="col" bgcolor="#235996"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Judul Film</font></th>             
                    <th width="19%" align="Center" scope="col" bgcolor="#235996"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Tgl Kembali</font></th> 
                    <th width="6%" align="Center" scope="col" bgcolor="#235996"><font color="#FFFFFF">Aksi</font></th>
                    </tr>

                    <%

                        String kodePenyewaan = null;
                        String namaCustomer = null;
                        String judulFilm = null;
                        Date tglKembali;


                        try {
                            Koneksi konek = new Koneksi();
                            Connection conn = konek.bukaKoneksi();
                            Statement stm = conn.createStatement();
                            String sql = "SELECT a.kode_penyewaan as kode_penyewaan,a.tgl_kembali, b.nama_customer as nama_customer, c.judul_film as judul_film FROM pengembalian a inner join customer b on a.kode_customer = b.kode_customer inner join datafilm c on a.kode_film = c.kode_film ORDER BY a.id DESC";
                            ResultSet res = stm.executeQuery(sql);
                            while (res.next()) {
                                kodePenyewaan = res.getString("kode_penyewaan");
                                namaCustomer = res.getString("nama_customer");
                                judulFilm = res.getString("judul_film");
                                tglKembali = res.getDate("tgl_kembali");

                    %>
                   
                 <tr>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=kodePenyewaan%></font></td>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=namaCustomer%></font></td>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=judulFilm%></font></td>
                    <th align="Center" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=tglKembali%></font></th>
                    <th align="Center" scope="col" bgcolor="#CCCCCC"> <a href="PengembalianController?Hapus=Hapus&amp;kodePenyewaan=<%=kodePenyewaan%>"> <img src="Gambar/Hapus.png" width="15" height="15" title="Hapus" /></a></th>   
            <!--    <th align="Center" scope="col" bgcolor="#CCCCCC"> <input type="submit" name="Hapus" value="Hapus" />  <input type="hidden" name="kdpeminjamantxt" value="<%=kodePenyewaan%>" /> </th> -->
                </tr>
              
                   
          
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
            </form>
        </td>
        </tr>
    </table>
</div>

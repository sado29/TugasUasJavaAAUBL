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
				
        $("#tglJual").datepicker({
            showOn: "both", buttonImage: "Gambar/calendarr.png", buttonImageOnly: true, changeMonth: true, changeYear: true, dateFormat: "yy-mm-dd"});
	  	  			  
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
            $('#kodeFilm').focus()
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
        <th align="left" scope="col"><font color="#000000" size="3" face="Tahoma, Geneva, sans-serif">DATA TRANSAKSI PENJUALAN FILM</font></th>
        </tr>
        <tr>
        <td><hr /></td>
        </tr>
        <tr>
        <td>
            <form id="form1" name="form1" method="post" action="PenjualanController">
                <table width="400" border="0" align="left">
                    <tr>
                    <td width="40%" align="left" valign="middle">Kode Penjualan</td>
                    <td width="2%" align="left" valign="middle">:</td>
                    <td width="68%" align="left" valign="top"><input name="kodePenjualan" type="text" id="kodePenyewaan" size="5" maxlength="5" /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="middle">&nbsp;</td>
                    <td align="left" valign="middle">&nbsp;</td>
                    <td align="left" valign="top"><hr /></td>
                    </tr>
                    <tr>
                    <td align="left" valign="middle">Kode Customer</td>
                    <td align="left" valign="middle">:</td>
                    <td align="left" valign="top"><input name="kodeCustomer" type="text" id="kodeCustomer" size="5" maxlength="5" /></td>
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
                    <td align="left" valign="top"><input name="kodeFilm" type="text" id="kodeFilm" size="5" maxlength="5" /></td>
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
                    <td align="left" valign="top">Tgl Jual</td>
                    <td align="left" valign="top">:</td>
                    <td align="left" valign="middle">
                        <input name="tglJual" type="text" id="tglJual" value="" size="10" maxlength="10" readonly="readonly" />
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
                    <th width="19%" align="Center" scope="col" bgcolor="#235996"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Tgl Jual</font></th>  
                    <th width="6%" align="Center" scope="col" bgcolor="#235996"><font color="#FFFFFF">Aksi</font></th>
                    </tr>

                    <%

                        String kodePenjualan = null;
                        String namaCustomer = null;
                        String judulFilm = null;
                        Date tglJual;
                       
                        try {
                            Koneksi konek = new Koneksi();
                            Connection conn = konek.bukaKoneksi();
                            Statement stm = conn.createStatement();
                            String sql = "SELECT a.kode_penjualan as kode_penjualan,a.tgl_jual,b.nama_customer as nama_customer, c.judul_film as judul_film FROM penjualan a inner join customer b on a.kode_customer = b.kode_customer inner join datafilm c on a.kode_film = c.kode_film ORDER BY a.id DESC";
                            ResultSet res = stm.executeQuery(sql);
                            while (res.next()) {
                                kodePenjualan = res.getString("kode_penjualan");
                                namaCustomer = res.getString("nama_customer");
                                judulFilm = res.getString("judul_film");
                                tglJual = res.getDate("tgl_jual");

                    %>
                   
                 <tr>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=kodePenjualan%></font></td>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=namaCustomer%></font></td>
                    <td align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=judulFilm%></font></td>
                    <th align="left" scope="col" bgcolor="#CCCCCC"><font face="Tahoma, Geneva, sans-serif" size="2"><%=tglJual%></font></th>
                    <th align="Center" scope="col" bgcolor="#CCCCCC"> <a href="PenjualanController?Hapus=Hapus&amp;kodePenjualan=<%=kodePenjualan%>"> <img src="Gambar/Hapuss.png" width="15" height="15" title="Hapus" /></a></th>   
            <!--    <th align="Center" scope="col" bgcolor="#CCCCCC"> <input type="submit" name="Hapus" value="Hapus" />  <input type="hidden" name="kdpeminjamantxt" value="<%=kodePenjualan%>" /> </th> -->
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
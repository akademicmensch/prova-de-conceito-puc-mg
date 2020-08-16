package br.com.sigo.crystalreport.services;

import java.io.ByteArrayInputStream;

import br.com.sigo.crystalreport.models.Relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;


public class GeneratePdf {
	
	public static ByteArrayInputStream relatorioSigo(String id) {
		Relatorio rel = new Relatorio(id);
		String conteudo = "";
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	PdfPTable table1 = new PdfPTable(1);
            table1.setWidthPercentage(80);
            table1.setWidths(new int[]{1});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell1;
            hcell1 = new PdfPCell(new Phrase("Nome relatorio", headFont));
            hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.addCell(hcell1);
            PdfPCell cell1;
            cell1 = new PdfPCell(new Phrase(rel.getTitulo()));
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.addCell(cell1);
            
            
            PdfPTable table2 = new PdfPTable(1);
            table2.setWidthPercentage(40);
            table2.setWidths(new int[]{1});
            PdfPCell hcell2;
            hcell2 = new PdfPCell(new Phrase("Processado em", headFont));
            hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(hcell2);
            PdfPCell cell2;
            cell2 = new PdfPCell(new Phrase(rel.getData()));
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(cell2);
            
            buscarConteudo(rel);
            
            PdfPTable table3 = new PdfPTable(1);
            table3.setWidthPercentage(100);
            table3.setWidths(new int[]{1});
            PdfPCell hcell3;
            hcell3 = new PdfPCell(new Phrase("Conteudo", headFont));
            hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3.addCell(hcell3);
            PdfPCell cell3;
            cell3 = new PdfPCell(new Phrase(rel.getConteudo()));
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3.addCell(cell3);
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table1);
            document.add(table2);
            document.add(table3);
            
            document.close();
            
        }catch(DocumentException ex) {
        	System.out.println(ex);
        }
		
		
        return new ByteArrayInputStream(out.toByteArray());
	}

	private static void buscarConteudo(Relatorio rel) {
		
		if(rel.getId().equalsIgnoreCase("1")) {
			rel.setConteudo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu leo consequat diam venenatis feugiat et vitae magna. Pellentesque pharetra felis justo, et mollis enim facilisis a. Sed et libero eros. Curabitur sed lacinia mauris. Curabitur quis vehicula nisl. Fusce fringilla laoreet mi ut scelerisque. Quisque eros felis, tincidunt eget nisl sit amet, convallis convallis quam. Morbi dapibus orci ultricies felis ullamcorper, efficitur scelerisque risus dictum. Phasellus risus quam, interdum sit amet suscipit et, molestie ut purus. Donec in urna vitae nulla consequat congue vel nec ante. Cras sodales eros sapien, vel semper neque faucibus ut. Phasellus vitae ante congue, lobortis urna id, congue turpis. Vivamus id ullamcorper justo. Quisque sit amet feugiat erat, eu mollis magna. Integer non justo venenatis massa imperdiet volutpat quis pulvinar sapien.");
		}else if(rel.getId().equalsIgnoreCase("2")) {
			rel.setConteudo("Cras dignissim vehicula gravida. Fusce porta gravida quam sed euismod. Praesent interdum vel urna sit amet faucibus. Nunc ac diam a nulla maximus rhoncus a eget velit. Donec molestie sit amet neque ac bibendum. Cras a urna sed felis dictum faucibus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
		}else if(rel.getId().equalsIgnoreCase("3")) {
			rel.setConteudo("Nunc dapibus leo vitae tortor commodo, et ultrices augue pulvinar. Ut at neque sollicitudin, hendrerit elit sed, tempus massa. Sed convallis odio neque, sit amet condimentum magna laoreet quis. Sed rutrum commodo finibus. Nullam sollicitudin est sed posuere scelerisque. Praesent et faucibus sem. Sed maximus porttitor sapien. Duis nec nibh non nulla porttitor eleifend. Integer vitae enim accumsan magna suscipit semper. Maecenas eu urna urna. Proin cursus quam magna, vitae pulvinar nibh vulputate mattis. Duis sit amet erat ac nibh sagittis elementum ac vel dolor. Nam mattis a nibh viverra venenatis. Suspendisse dui nibh, commodo vel varius sed, rhoncus non ante. Morbi id consequat erat. Nulla a commodo quam.");
		}else if(rel.getId().equalsIgnoreCase("4")) {
			rel.setConteudo("Proin et elit eget velit malesuada congue. Nam tellus ex, rhoncus eu lacinia eu, sodales vel ipsum. Fusce nisi massa, convallis quis tristique sit amet, pellentesque a enim. Maecenas rutrum enim erat, eget pulvinar urna tristique a. Etiam quis venenatis leo, ac viverra arcu. Quisque auctor auctor arcu, ut porttitor elit sollicitudin vel. Quisque sed tempor urna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur ut ornare nisl. Sed ornare dolor mi, pulvinar varius diam aliquam vel. Pellentesque efficitur metus auctor, vestibulum purus et, elementum urna. Integer et neque eget ante rutrum porta vitae vel lacus Vivamus a metus ultricies, bibendum felis non, tempus neque. Ut metus neque, scelerisque in placerat in, convallis et felis. Nullam mollis fermentum orci, at dignissim libero interdum eu. Aenean sed est eget justo malesuada auctor. Ut pretium venenatis ullamcorper. Nunc suscipit tincidunt odio, ut faucibus urna. Phasellus imperdiet et urna in dignissim.");
		}else if(rel.getId().equalsIgnoreCase("5")) {
			rel.setConteudo("Pellentesque rutrum aliquam nunc quis semper. Morbi iaculis cursus lobortis. Nullam euismod, felis sit amet accumsan dictum, eros urna bibendum urna, auctor pellentesque ligula felis non justo. Fusce dictum tincidunt tincidunt. Nulla rhoncus dolor a pellentesque efficitur. Integer pulvinar, nibh sit amet cursus posuere, augue ligula faucibus urna, a mollis ex turpis et felis. Duis metus nisi, sollicitudin faucibus vehicula sit amet, facilisis a magna. Sed dictum, mauris nec fringilla elementum, risus odio finibus lacus, at varius dui tellus ut velit. Sed vulputate felis id felis elementum, ac laoreet neque vulputate. Sed tristique consectetur lectus eget fringilla. Vestibulum hendrerit auctor ultricies. Curabitur pellentesque velit commodo lacus tempus, sit amet dapibus est sodales. Ut efficitur, magna in interdum eleifend, lectus magna volutpat nibh, ac cursus massa enim nec est. Suspendisse in mattis metus. Duis scelerisque orci ante, nec aliquam ex volutpat vitae.");
		}else if(rel.getId().equalsIgnoreCase("6")) {
			rel.setConteudo("In efficitur quis eros id pretium. Pellentesque eu accumsan lectus, ac placerat nisl. Curabitur tortor ante, dignissim eget consectetur sed, viverra scelerisque mauris. Nam vulputate, nibh a pretium vestibulum, ex ligula sagittis augue, sit amet tempus ante augue at turpis. Curabitur tempor faucibus dolor, vitae elementum elit. Fusce dapibus, turpis nec maximus blandit, lectus dolor laoreet quam, ac bibendum ligula enim non ex. Integer tempor est quam, non fringilla turpis fringilla sed. Proin feugiat ligula sed diam venenatis, eget vehicula nibh interdum. Pellentesque vel ex semper, tincidunt diam vel, sodales lectus. Phasellus nec ullamcorper nisl, sit amet dictum orci. Sed mollis fringilla risus, nec fringilla nibh ornare eget. Integer et tempor lorem. Maecenas scelerisque vel sapien quis efficitur. Mauris vel ipsum sodales, interdum massa sed, aliquam velit.");
		}
		
	}
}

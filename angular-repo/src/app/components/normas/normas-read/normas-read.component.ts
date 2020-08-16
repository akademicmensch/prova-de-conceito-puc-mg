import { Component, OnInit } from '@angular/core';
import { NormaService } from '../norma.service';
import { Norma } from '../norma.model';
import { FileService } from './File.service';
import{ ReponseTypeToPDF } from '../reponsepdf.model';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import {ModalDescricaoComponent} from '../modal-descricao/modal-descricao.component';

@Component({
  selector: 'app-normas-read',
  templateUrl: './normas-read.component.html',
  styleUrls: ['./normas-read.component.css']
})
export class NormasReadComponent implements OnInit {

  loading = false;
  textVal:any;
  public responsePdf:ReponseTypeToPDF;
  normas:Norma[];
  norma:Norma;

  normass:Norma[];

  dialogConfig = new MatDialogConfig();

  displayedColumns = ['nome', 'descricao', 'categoria', 'status', 'consultoria', 'processo', 'acao']

  constructor(private normaService: NormaService,
    private fileService: FileService, private dialog:MatDialog) { }

  ngOnInit(): void {
    this.loading = true
    this.normaService.read().subscribe(normas => {
      console.log(this.normas)
      this.normas = normas
      console.log('O QUE VEM DA API GET - ')
      console.log(this.normas)
      this.loading = false
    })
  }

  inputFile(event, id) {
      if (event.target.files && event.target.files[0]) {
        const file = event.target.files[0];
        const formData = new FormData();
        formData.append('pdf', file);
        console.log("ID: ");
        console.log(id);
        this.fileService.upload(formData, id).subscribe((res) => {
          console.log(res)
        }), err => {
          console.log(err);
        }

    }

  }

openPdf(event, id){
  console.log('NORMAS READ COMPONENT');
  console.log('ID VINDO DO OPENPDF');
  console.log(id);
  let newPdfWindow = window.open("","Print");

  this.normaService.getByteArrayPdf(id).subscribe(responsePdf => {
    this.responsePdf = responsePdf;
    console.log("RESPOSTA DENTRO DO METODO: ");
    console.log(this.responsePdf);

    console.log("RESPOSTA DENTRO DO METODO - OBJETO QUE CHEGA DA API ANTES DO MAPEAMENTO: ");
    console.log(responsePdf);

    let newPdfWindow = window.open("","Print");
    let content = encodeURIComponent(this.responsePdf.pdf);

    let iframeStart = "<\iframe width='100%' height='100%' src='data:application/pdf;base64, ";

    let iframeEnd = "'><\/iframe>";
  
    newPdfWindow.document.write(iframeStart + content + iframeEnd);

  });
  
}

openDialog(id:number){

    console.log("ID QUE VEIO DA SELECAO");
    console.log(id)

    this.normass = this.normas;
    console.log("COPIA DO ARRAY DE NORMAS")
    console.log(this.normass);

    this.normass.forEach(norma => {
     
      if(norma.id === id){

        console.log("ID DO norma.id");
        console.log(norma.id);

        console.log("ID QUE VEIO DA FUNCAO");
        console.log(id);

        console.log("OBJETO EM SI: ");
        console.log(norma);


    this.dialogConfig.disableClose = false;
    this.dialogConfig.autoFocus = true;
    this.dialogConfig.minWidth = '50%';
    this.dialogConfig.minHeight = '500px';
    this.dialogConfig.data = {
    desc: norma.descricao
    }

    this.dialog.open(ModalDescricaoComponent, this.dialogConfig).afterClosed().subscribe(result => {
      norma.descricao = result;
    })

      }
    });

 /*   this.dialogConfig.disableClose = false;
    this.dialogConfig.autoFocus = true;
    this.dialogConfig.minWidth = '50%';
    this.dialogConfig.minHeight = '500px';
    this.dialogConfig.data = {
    desc: this.norma.descricao
    }

    this.dialog.open(ModalDescricaoComponent, this.dialogConfig).afterClosed().subscribe(result => {
      this.norma.descricao = result;
    })*/



}

}

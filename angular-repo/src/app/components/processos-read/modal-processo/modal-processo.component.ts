import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';
import { RootObject } from '../../processos-read/processos.model';

@Component({
  selector: 'app-modal-processo',
  templateUrl: './modal-processo.component.html',
  styleUrls: ['./modal-processo.component.css']
})
export class ModalProcessoComponent implements OnInit {

  constructor(private dialogRef:  MatDialogRef<ModalProcessoComponent>, @Inject(MAT_DIALOG_DATA) data) {
    this.processo = data;
    this.nomeProcesso = data.processo.nome;
    this.etapa1 = data.processo.detalhe.etapa1;
    this.etapa2 = data.processo.detalhe.etapa2;
    this.etapa3 = data.processo.detalhe.etapa3;
    this.etapa4 = data.processo.detalhe.etapa4;
    this.etapa5 = data.processo.detalhe.etapa5;
    this.etapa6 = data.processo.detalhe.etapa6;
    this.etapa7 = data.processo.detalhe.etapa7;
    this.etapa8 = data.processo.detalhe.etapa8;
    this.etapa9 = data.processo.detalhe.etapa9;
    this.etapa10 = data.processo.detalhe.etapa10;
  }

  processo:RootObject;
  nomeProcesso:string;
  pessoasEnvolvidas:string;
  etapa1:string;
  etapa2:string;
  etapa3:string;
  etapa4:string;
  etapa5:string;
  etapa6:string;
  etapa7:string;
  etapa8:string;
  etapa9:string;
  etapa10:string;

  ngOnInit(): void {
  }




  close(){
    this.dialogRef.close(this.processo)
  }

}

import { Component, OnInit } from '@angular/core';
import {ProcessosService} from './processos.service';
import { RootObject } from './processos.model';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { ModalProcessoComponent } from './modal-processo/modal-processo.component';

@Component({
  selector: 'app-processos-read',
  templateUrl: './processos-read.component.html',
  styleUrls: ['./processos-read.component.css']
})
export class ProcessosReadComponent implements OnInit {

  dialogConfig = new MatDialogConfig()
  rootObject: RootObject[]
  indRootObject: RootObject
  nome:string
  displayedColumns = ['nome', 'quantidadePessoasEnvolvidas', 'provisorio', 'action']

  constructor(private processosService:ProcessosService, private dialog:MatDialog) { }

  ngOnInit(): void {
    this.processosService.readAllProcesses().subscribe(rootObject =>{
      this.rootObject = rootObject
      console.log(this.rootObject)
    })
  }


  openNewDialog(id:string){

    console.log("ID CHEGANDO DO OPEN DIALOG DE PROCESSO")
    console.log(id)

    this.rootObject.forEach(rootObj => {
      if(rootObj.id === id){
        this.dialogConfig.disableClose = false;
        this.dialogConfig.autoFocus = true;
        this.dialogConfig.minWidth = '50%';
        this.dialogConfig.minHeight = '500px';
        this.dialogConfig.data = {
          processo: rootObj
        }

        this.dialog.open(ModalProcessoComponent, this.dialogConfig).afterClosed().subscribe(result => {
          this.indRootObject = result;
        })

      }
    });

    

  }

}
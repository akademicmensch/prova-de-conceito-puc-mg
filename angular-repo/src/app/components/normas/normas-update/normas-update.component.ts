import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { NormaService } from '../norma.service';
import { Norma } from '../norma.model';
import { NormaCreateModel } from '../normas-create/NormaCreate.model'
import { Categoria } from '../categoria.model';
import { Consultoria } from '../consultoria.model';
import { Processo } from '../processo.model';
import { ConsultoriaService } from '../consultoria.service';
import { ProcessoService } from '../processo.service';
import {ModalDescricaoComponent} from '../modal-descricao/modal-descricao.component';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-normas-update',
  templateUrl: './normas-update.component.html',
  styleUrls: ['./normas-update.component.css']
})
export class NormasUpdateComponent implements OnInit {
  norma: Norma;
  normaC:NormaCreateModel;


  public cat1 = new Categoria(1, 'ambiental');

  public cat2 = new Categoria(2, 'industrial');

  public cat3 = new Categoria(3, 'interno');

  public cat4 = new Categoria(4, 'tributario');

  public categorias: Categoria[] = new Array;

  public consultorias: Consultoria[] = new Array;

  public processos: Processo[] = new Array;

  public normaContract: NormaCreateModel = new NormaCreateModel();

  dialogConfig = new MatDialogConfig()


  constructor( private router: Router, private route: ActivatedRoute, private normaService: NormaService, private consultoriaService:ConsultoriaService, private processoService:ProcessoService, private dialog:MatDialog) { }

  ngOnInit(): void {

    console.log('Valor cat1');
    console.log(this.cat1);
    this.categorias.push(this.cat1);this.categorias.push(this.cat2);this.categorias.push(this.cat3);this.categorias.push(this.cat4);
    console.log('ARRAY DE CATEGORIAS:  ')
    console.log(this.categorias)

    this.consultoriaService.getAll().subscribe((data: any[]) =>{
      console.log(data);
      this.consultorias = data;
    })

    this.processoService.getAllProcessos().subscribe((data: any[]) =>{
      console.log(data);
      this.processos = data
    })



    const id = +this.route.snapshot.paramMap.get("id");
    this.normaService.readById(id).subscribe((norma) => {
      this.norma = norma;
    });



  }

  update(): void {
    this.normaService.update(this.norma).subscribe(() => {
      //this.productService.showMessage("Produto atualizado com sucesso!");
      this.router.navigate(["/normas"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/normas"]);
  }

  openDialog(){

    this.dialogConfig.disableClose = false;
    this.dialogConfig.autoFocus = true;
    this.dialogConfig.minWidth = '50%';
    this.dialogConfig.minHeight = '500px';
    this.dialogConfig.data = {
      desc: this.norma.descricao,
    }

    this.dialog.open(ModalDescricaoComponent, this.dialogConfig).afterClosed().subscribe(result => {
      this.norma.descricao = result;
      console.log(this.norma)
  })
}

}

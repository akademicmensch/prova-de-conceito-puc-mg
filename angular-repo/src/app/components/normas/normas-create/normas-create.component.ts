import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Norma } from '../norma.model';
import { NormaService } from '../norma.service';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';
import { Consultoria } from '../consultoria.model';
import { ConsultoriaService } from '../consultoria.service';
import { Processo } from '../processo.model';
import { ProcessoService } from '../processo.service';
import { NormaCreateModel } from './NormaCreate.model';

@Component({
  selector: 'app-normas-create',
  templateUrl: './normas-create.component.html',
  styleUrls: ['./normas-create.component.css']
})
export class NormasCreateComponent implements OnInit {

  norma: Norma = {
    nome: '',
    descricao: '',
    categoria: 0,
    status: 1,
    consultoria: 0,
    processo: '',
    categoriaDesc: '',
    statusDesc: '',
    consultoriaDesc: ''
  }

  public cat1 = new Categoria(1, 'ambiental');

  public cat2 = new Categoria(2, 'industrial');

  public cat3 = new Categoria(3, 'interno');

  public cat4 = new Categoria(4, 'tributario');

  public categorias: Categoria[] = new Array;

  public consultorias: Consultoria[] = new Array;

  public processos: Processo[] = new Array;

  public normaContract: NormaCreateModel = new NormaCreateModel();

  constructor(private normaService: NormaService,
    private router: Router, private categoriaService: CategoriaService, private consultoriaService: ConsultoriaService, private processoService: ProcessoService) {}

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

    console.log('VALOR DE CONSULTORIAS NOVO METODO')
    console.log(this.consultorias)
}

  createNorma(): void {
    console.log(this.norma)

    this.normaContract.nome = this.norma.nome
    this.normaContract.descricao = this.norma.descricao
    this.normaContract.categoria = this.norma.categoria
    this.normaContract.consultoria = this.norma.consultoria
    this.normaContract.processo = this.norma.processo
    this.normaContract.status = 1

    console.log('CONTRATO QUE FOI PASSADO PARA GRAVAR: ')
    console.log(this.normaContract)

    this.normaService.create(this.normaContract).subscribe(() => {
      this.router.navigate(['/normas'])
    });
    alert('Norma Criada');
  }

  cancel(): void {
    this.router.navigate(['/normas'])
  }

}

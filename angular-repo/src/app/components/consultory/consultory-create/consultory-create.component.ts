import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsultoriaCreate } from './consultoriaCreate.model';
import { ConsultoriaService } from '../../normas/consultoria.service';
import { Processo } from '../../normas/processo.model';
import { ProcessoService } from '../../normas/processo.service';

@Component({
  selector: 'app-consultory-create',
  templateUrl: './consultory-create.component.html',
  styleUrls: ['./consultory-create.component.css']
})
export class ConsultoryCreateComponent implements OnInit {


  consultoria:ConsultoriaCreate = {
    descricao: '',
    cnpj: '',
    status: 0,
    processo: '',
    fimContrato: '',
    inicioContrato: ''
  }

  consultoriaCriar:ConsultoriaCreate = {
    descricao: '',
    cnpj: '',
    status: 0,
    processo: '',
    fimContrato: '',
    inicioContrato: ''
  }

  public processos: Processo[] = new Array;

  constructor(private router: Router, private consultoriaService:ConsultoriaService, private processoService:ProcessoService) { }

  ngOnInit(): void {

    this.processoService.getAllProcessos().subscribe((data: any[]) =>{
      console.log(data);
      this.processos = data
    })


  }




  createConsultoria(): void {

    console.log('CONTRATO QUE FOI PASSADO PARA GRAVAR: ')
    this.consultoriaCriar = this.consultoria
    console.log(this.consultoriaCriar)
   

    this.consultoriaService.createConsultoria(this.consultoriaCriar).subscribe(() => {
      this.router.navigate(['/consultorias'])
    });
    alert('Consultoria Contratada');
  }

  cancel(): void {
    this.router.navigate(['/consultorias'])
  }

}

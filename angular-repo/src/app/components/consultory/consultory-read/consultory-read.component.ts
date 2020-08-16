import { Component, OnInit } from '@angular/core';
import { ConsultoriaService } from '../../normas/consultoria.service';
import { Consultoria2 } from '../../normas/consultoria2.model';

@Component({
  selector: 'app-consultory-read',
  templateUrl: './consultory-read.component.html',
  styleUrls: ['./consultory-read.component.css']
})
export class ConsultoryReadComponent implements OnInit {

  consultorias:Consultoria2[]
  displayedColumns = ['descricao', 'status', 'cnpj', 'inicioContrato', 'fimContrato', 'processo', 'acao']

  constructor(private consultoriaService:ConsultoriaService) { }

  ngOnInit(): void {
    this.consultoriaService.readModel2().subscribe(consultorias => {
      this.consultorias = consultorias
      console.log('O QUE VEM DA API GET - CONSULTORIAS')
      console.log( this.consultorias)
    })
  }
}

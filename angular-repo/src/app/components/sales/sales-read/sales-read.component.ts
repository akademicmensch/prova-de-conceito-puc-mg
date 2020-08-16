import { Component, OnInit } from '@angular/core';
import { SalesService } from './sales-read.service'

@Component({
  selector: 'app-sales-read',
  templateUrl: './sales-read.component.html',
  styleUrls: ['./sales-read.component.css']
})
export class SalesReadComponent implements OnInit {

  constructor(private salesService:SalesService) { }

  completo:object
  dia:object;
  mes:object;
  ano:object;

  testeNomeDia:string


  diatecidoSintetico:string;
  diatecidoSemiSintetico:string;
  diatecidoNatural:string;
  diaquantidadeVendaTecidoSintetico:string;
  diaquantidadeVendaTecidoSemiSintetico:string;
  diaquantidadeVendaTecidoNatural:string;
  diavalorVendaTecidoSintetico:string;
  diavalorVendaTecidoSemiSintetico:string;
  diavalorVendaTecidoNatural:string;


  mesmesAtual:string;
  mestecidoSintetico:string;
  mestecidoSemiSintetico:string;
  mestecidoNatural:string;
  mesquantidadeVendaTecidoSintetico:string;
  mesquantidadeVendaTecidoSemiSintetico:string;
  mesquantidadeVendaTecidoNatural:string;
  mesvalorVendaTecidoSintetico:string;
  mesvalorVendaTecidoSemiSintetico:string;
  mesvalorVendaTecidoNatural:string;

  anoanoAtual:string;
  anotecidoSintetico:string;
  anotecidoSemiSintetico:string;
  anotecidoNatural:string;
  anoquantidadeVendaTecidoSintetico:string;
  anoquantidadeVendaTecidoSemiSintetico:string;
  anoquantidadeVendaTecidoNatural:string;
  anovalorVendaTecidoSintetico:string;
  anovalorVendaTecidoSemiSintetico:string;
  anovalorVendaTecidoNatural:string;





  displayedColumns = ['material', 'quantidade', 'valor']

  ngOnInit(): void {

    this.salesService.getSales(this.completo).subscribe(res =>{
      

      this.testeNomeDia = res.dia.tecidoNatural;
      
      this.diatecidoSintetico = res.dia.tecidoSintetico;
      this.diatecidoSemiSintetico = res.dia.tecidoSemiSintetico;
      this.diatecidoNatural = res.dia.tecidoNatural;
      this.diaquantidadeVendaTecidoSintetico = res.dia.quantidadeVendaTecidoSintetico;
      this.diaquantidadeVendaTecidoSemiSintetico = res.dia.quantidadeVendaTecidoSemiSintetico;
      this.diaquantidadeVendaTecidoNatural = res.dia.quantidadeVendaTecidoNatural;
      this.diavalorVendaTecidoSintetico = res.dia.valorVendaTecidoSintetico;
      this.diavalorVendaTecidoSemiSintetico = res.dia.valorVendaTecidoSemiSintetico;
      this.diavalorVendaTecidoNatural = res.dia.valorVendaTecidoNatural;
    
    
      this.mesmesAtual = res.mes.mesAtual;
      this.mestecidoSintetico = res.mes.tecidoSintetico;
      this.mestecidoSemiSintetico = res.mes.tecidoSemiSintetico;
      this.mestecidoNatural = res.mes.tecidoNatural;
      this.mesquantidadeVendaTecidoSintetico = res.mes.quantidadeVendaTecidoSintetico;
      this.mesquantidadeVendaTecidoSemiSintetico = res.mes.quantidadeVendaTecidoSemiSintetico;
      this.mesquantidadeVendaTecidoNatural = res.mes.quantidadeVendaTecidoNatural;
      this.mesvalorVendaTecidoSintetico = res.mes.valorVendaTecidoSintetico;
      this.mesvalorVendaTecidoSemiSintetico = res.mes.valorVendaTecidoSemiSintetico;
      this.mesvalorVendaTecidoNatural = res.mes.valorVendaTecidoNatural;
    
      this.anoanoAtual = res.ano.anoAtual;
      this.anotecidoSintetico = res.ano.tecidoSintetico;
      this.anotecidoSemiSintetico = res.ano.tecidoSemiSintetico;
      this.anotecidoNatural = res.ano.tecidoNatural;
      this.anoquantidadeVendaTecidoSintetico = res.ano.quantidadeVendaTecidoSintetico;
      this.anoquantidadeVendaTecidoSemiSintetico = res.ano.quantidadeVendaTecidoSemiSintetico;
      this.anoquantidadeVendaTecidoNatural = res.ano.quantidadeVendaTecidoNatural;
      this.anovalorVendaTecidoSintetico = res.ano.valorVendaTecidoSintetico;
      this.anovalorVendaTecidoSemiSintetico = res.ano.valorVendaTecidoSemiSintetico;
      this.anovalorVendaTecidoNatural = res.ano.valorVendaTecidoNatural;




    }, erro=>{
      console.log(erro)
    })

  }


  

}

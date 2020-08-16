import { Component, OnInit } from '@angular/core';
import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router'
@Component({
  selector: 'app-processos-crud',
  templateUrl: './processos-crud.component.html',
  styleUrls: ['./processos-crud.component.css']
})
export class ProcessosCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Processos Industriais IndTexBr',
      icon: 'storefront',
      routeUrl: '/processos'
    }
  }

  ngOnInit(): void {
  }

}

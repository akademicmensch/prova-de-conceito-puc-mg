import { Component, OnInit } from '@angular/core';
import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-consultory-crud',
  templateUrl: './consultory-crud.component.html',
  styleUrls: ['./consultory-crud.component.css']
})
export class ConsultoryCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Cadastro de Consultoria',
      icon: 'storefront',
      routeUrl: '/consultorias'
    }
  }

  ngOnInit(): void {
  }

  navigateToConsultoryCreate(): void {
    this.router.navigate(['/consultorias/create'])
  }

}

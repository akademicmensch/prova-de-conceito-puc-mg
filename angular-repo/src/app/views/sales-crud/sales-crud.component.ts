import { Component, OnInit } from '@angular/core';
import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-sales-crud',
  templateUrl: './sales-crud.component.html',
  styleUrls: ['./sales-crud.component.css']
})
export class SalesCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Monitor de vendas',
      icon: 'storefront',
      routeUrl: '/vendas'
    }
  }

  ngOnInit(): void {
  }

}

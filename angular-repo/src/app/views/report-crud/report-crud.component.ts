import { Component, OnInit } from '@angular/core';
import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-report-crud',
  templateUrl: './report-crud.component.html',
  styleUrls: ['./report-crud.component.css']
})
export class ReportCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Relatorios CrystalReports',
      icon: 'storefront',
      routeUrl: '/relatorios'
    }
  }

  ngOnInit(): void {
  }

}

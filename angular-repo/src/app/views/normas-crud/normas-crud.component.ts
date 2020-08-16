import { Component, OnInit } from '@angular/core';
import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-normas-crud',
  templateUrl: './normas-crud.component.html',
  styleUrls: ['./normas-crud.component.css']
})
export class NormasCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) { 
    headerService.headerData = {
      title: 'Cadastro de Norma',
      icon: 'storefront',
      routeUrl: '/normas'
    }
  }

  ngOnInit(): void {
  }

  navigateToNormasCreate(): void {
    this.router.navigate(['/normas/create'])
  }

}

import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  admin:boolean = false;

  constructor(private p:AppComponent) { }

  ngOnInit(): void {

    let s = localStorage.getItem("role");
    console.log('VALOR DE ROLE NO NAV COMPONENT: ')
    console.log(s)
    if(s==='admin'){
      console.log('A validacao foi verdadeira')
      console.log(s==='admin')
      this.admin = true;
      this.p.admin = true;
    }else{
      console.log('A validacao foi falsa')
      console.log(s==='admin')
      this.admin = false;
      this.p.admin = false;
    }
  }

}

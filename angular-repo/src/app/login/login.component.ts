import { Component, OnInit } from '@angular/core';
import { LoginService} from './login.service';
import {Router} from "@angular/router";
import {AppRoutingModule} from "../app-routing.module"
import { AppComponent } from '../app.component';
import { AppModule } from '../app.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario:string;
  senha:string;

  logo:string = "";

  constructor(private loginService:LoginService, private p:AppComponent) { }

  ngOnInit(): void {
  }

  async acessar(){
    let usuario={
      username:this.usuario,
      password:this.senha
    }
    console.log('USUARIO PASSADO')
    console.log(this.usuario)
    this.loginService.getJwt(usuario).subscribe(res =>{
      console.log(res);
      localStorage.setItem("token",res.jwt)
    }, erro=>{
      console.log(erro)
    })
    await new Promise(r => setTimeout(r, 2000));

    let role={
      jwt:localStorage.getItem("token")
    }

    this.loginService.getRole(role).subscribe(res =>{
      console.log(res);
      localStorage.setItem("name",res.name)
      localStorage.setItem("role",res.role)
    })

    if(localStorage.getItem("token")==null || localStorage.getItem("name")==null || localStorage.getItem("role")==null){
      this.p.acessoPermitido = false;
    }else{
      this.p.acessoPermitido = true;
    }
    
  }

}

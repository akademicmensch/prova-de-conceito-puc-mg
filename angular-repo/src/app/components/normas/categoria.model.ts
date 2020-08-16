export class Categoria {
    id?: number
    descricao: string

    constructor(private id_:number, private descricao_:string){
this.descricao = descricao_;
this.id = id_;
    }
}
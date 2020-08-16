export class Consultoria {
    
    id?: number
    descricao: string
    cnpj:string
    inicioContrato:string
    fimContrato:string
    processo:string

    constructor(private descricao_:string, private cnpj_:string, private inicioContrato_:string, private fimContrato_:string, private processo_:string){
this.descricao = descricao_;

    }
}
    export interface Detalhe {
        etapa1: string;
        etapa2: string;
        etapa3: string;
        etapa4: string;
        etapa5: string;
        etapa6: string;
        etapa7: string;
        etapa8: string;
        etapa9: string;
        etapa10: string;
    }

    export interface RootObject {
        id:string;
        nome: string;
        quantidadePessoas?: any;
        provisorio?: any;
        detalhe: Detalhe;
    }


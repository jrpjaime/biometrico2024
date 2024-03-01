export interface ModalType {

    type : string;
    title : string;
    text : string;
    imgSrc? : string;
    confirm? : Function;
    reject? : Function;
    dismiss? : Function;
    alerta? : boolean;
 
 }
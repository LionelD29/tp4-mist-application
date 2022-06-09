export interface Order {
    id: number;
    userRef: string;
    billingAddress: string;
    orderDate: Date;
    status: string;
}

export interface OrderForm {
    billingAddress: string;
    // games: Array<Game>;
}
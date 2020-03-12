class Customer {
    private _firstName: string;
    private _lastName: string;

    constructor(theFirst: string, theLast: string) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }

    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): string {
        return this._lastName;
    }

}


let myCustomer = new Customer("Breno", "Arantes");


console.log(myCustomer);
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
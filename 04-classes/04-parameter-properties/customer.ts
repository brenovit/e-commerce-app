class Customer {
    constructor(private _firstName: string, private _lastName: string) {
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


let myCustomer = new Customer("Breno", "Nunes");


console.log(myCustomer);
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
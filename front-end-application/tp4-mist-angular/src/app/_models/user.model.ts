export interface UserSignInForm {
    email: string;
    password: string;
}

export interface UserAccount {
    ref: string;
    username: string;
    email: string;
    roles: Array<string>;
}

export interface LocalStorageUser {
    username: string;
    email: string;
    roles: Array<string>;
}

export interface UserSignUpForm {
    firstName: string;
    lastName: string;
    birthDate: Date;
    email: string;
    phoneNumber: string;
    username: string;
    password: string;
}

export interface UserInfoDetail {
    firstName: string;
    lastName: string;
    birthDate: Date;
    email: string;
    phoneNumber: string;
    username: string;
    password: string;
}
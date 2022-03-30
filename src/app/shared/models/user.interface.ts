import { Role } from "./role.interface";

export interface User {
    username: string;
    password: string;
    roles: Role[];
}
import { Station } from "./station";

export class trip{
  tripId!: number;
  startTime!: string;
  endTime!: string;
  fromStation!:Station;
  toStation!:Station;
}

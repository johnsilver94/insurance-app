package com.enums;

public enum DriverCategory {
	AM("Mopeds","Two-wheel vehicles or three-wheel vehicles with a maximum design speed of not more than 45 kilometres per hour (28 mph) and with a cylinder capacity not exceeding 50 cubic centimetres (3.1 cu in)."),
	A1("Motorcycles","Motorcycles with a cylinder capacity not exceeding 125 cubic centimetres (7.6 cu in) and a power not exceeding 11 kilowatts (15 hp); and motor tricycles with a power not exceeding 15 kilowatts (20 hp)."),
	A2("Motorcycles","Motorcycles of a power not exceeding 35 kilowatts (47 hp) and with a power/weight ratio not exceeding 0.2 kilowatts per kilogram (0.12 hp/lb) (Switzerland: 0.16 kilowatts per kilogram (0.097 hp/lb)) and not derived from a vehicle of more than double its power."),
	A("Motorcycles","Any motorcycle or motor tricycle not in category A1/A2"),
	B("Motor vehicles","Motor vehicles with a maximum authorised mass (MAM) not exceeding 3,500 kilograms (7,700 lb) and designed and constructed for the carriage of no more than eight passengers in addition to the driver; motor vehicles in this category may be combined with a trailer having a maximum authorised mass which does not exceed 750 kilograms (1,650 lb). You can also tow heavier trailers if the total MAM of the vehicle and trailer isn�t more than 3,500 kilograms (7,700 lb)."),
	BE("Motor vehicles","Without prejudice to the provisions of type-approval drools for the vehicles concerned, a combination of vehicles consisting of a tractor vehicle in category B and a trailer or semi-trailer where the maximum authorised mass of the trailer or semi-trailer does not exceed 3,500 kilograms (7,700 lb)."),
	B1("Motor vehicles","Heavy quadricycles"),
	C1("Large goods vehicle","Large goods vehicle with a maximum authorised mass of not more than 7.5 tonnes (7.4 long tons; 8.3 short tons); with or without a trailer with a maximum mass of less than 750 kilograms (1,650 lb)."),
	C1E("Large goods vehicle","Combinations of vehicles where the tractor vehicle is in category C and its trailer or semi-trailer has a maximum authorised mass of over 750 kilograms (1,650 lb)."),
	C("Large goods vehicle","Large goods vehicle with a maximum authorised mass of more than 3.5 tonnes (3.4 long tons; 3.9 short tons) mass and not more than 8 + 1 seats (lorry); with a trailer with a maximum mass of 750 kilograms (1,650 lb)."),
	CE("Large goods vehicle","Other combinations of vehicles and trailers which with combined maximum authorised mass of more than 750 kilograms (1,650 lb)."),
	D1("Buses","Light buses with a maximum of 16 + 1 seats, maximum length of 8 metres (26 ft)."),
	D1E("Buses","Combinations of vehicles where the tractor vehicle is in category D1 and its trailer has a maximum authorised mass of over 750 kilograms (1,650 lb)."),
	D("Buses","Vehicles with more than 8 + 1 seats (buses)."),
	DE("Buses","Combinations of vehicles where the tractor vehicle is in category D and its trailer has a maximum authorised mass of over 750 kilograms (1,650 lb).");
	
	private final String category;
	private final String description;
	
	DriverCategory(String category,String description) {
        this.category = category;
        this.description = description;
    }
}

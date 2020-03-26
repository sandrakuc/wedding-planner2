package org.weddingplanner.utils;

import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

import java.util.Random;

public class CommonUtils {

    public static String generatePhoneNumber(){
        String phoneNumber = "+48";
        Random random = new Random();
        for(int i = 0; i < 9; i++){
            phoneNumber += String.valueOf(random.nextInt(10));
        }
        return phoneNumber;
    }

    public static final String BEAUTY_SALON_MODEL_CLASS_NAME = new BeautySalonListInternalModel().getClass().getName();
    public static final String CAR_RENTING_MODEL_CLASS_NAME = new CarRentingListInternalModel().getClass().getName();
    public static final String FLORISTIC_SERVICE_MODEL_CLASS_NAME = new FloristicServicesListInternalModel().getClass().getName();
    public static final String HAIR_DRESSER_CLASS_NAME = new HairDresserListInternalModel().getClass().getName();
    public static final String MAKE_UP_SALON_MODEL_CLASS_NAME = new MakeUpSalonListInternalModel().getClass().getName();
    public static final String MUSIC_BAND_MODEL_CLASS_NAME = new MusicBandListInternalModel().getClass().getName();
    public static final String PHOTOGRAPHER_MODEL_CLASS_NAME = new PhotographerListInternalModel().getClass().getName();
    public static final String WEDDING_DRESS_STORE_MODEL_CLASS_NAME = new WeddingDressStoreListInternalModel().getClass().getName();
    public static final String WEDDING_SUITE_MODEL_MODEL_CLASS_NAME = new WeddingSuitesListInternalModel().getClass().getName();
    public static final String WEDDING_HALL_MODEL_MODEL_CLASS_NAME = new WeddingHallListInternalModel().getClass().getName();

    public static final String BEAUTY_SALON_WEBSITE = "https://www.beauty-salon.lorem-ipsum.pl";
    public static final String CAR_RENTING_WEBSITE = "https://www.car-renting.lorem-ipsum.pl";
    public static final String FLORIST_WEBSITE = "https://www.florist.lorem-ipsum.pl";
    public static final String HAIR_DRESSER_WEBSITE = "https://www.hair-stylist.lorem-ipsum.pl";
    public static final String MAKE_UP_WEBSITE = "https://www.make-up-salon.lorem-ipsum.pl";
    public static final String MUSIC_BAND_WEBSITE = "https://www.music-band.lorem-ipsum.pl";
    public static final String PHOTOGRAPHER_WEBSITE = "https://www.photographer.lorem-ipsum.pl";
    public static final String WEDDING_SUITE_WEBSITE = "https://www.suite-store.lorem-ipsum.pl";
    public static final String WEDDING_DRESS_WEBSITE = "https://www.dress-store.lorem-ipsum.pl";
    public static final String WEDDING_HALL_WEBSITE = "https://www.wedding-hall.lorem-ipsum.pl";

    public static final String BEAUTY_SALON_EMAIL = "beauty-salon@lorem-ipsum.pl";
    public static final String CAR_RENTING_EMAIL = "car-renting@lorem-ipsum.pl";
    public static final String FLORIST_EMAIL = "florist@lorem-ipsum.pl";
    public static final String HAIR_DRESSER_EMAIL = "hair-stylist@lorem-ipsum.pl";
    public static final String MAKE_UP_EMAIL = "make-up-salon@lorem-ipsum.pl";
    public static final String MUSIC_BAND_EMAIL = "music-band@lorem-ipsum.pl";
    public static final String PHOTOGRAPHER_EMAIL = "photographer@lorem-ipsum.pl";
    public static final String WEDDING_SUITE_EMAIL = "suite-store@lorem-ipsum.pl";
    public static final String WEDDING_DRESS_EMAIL = "dress-store@lorem-ipsum.pl";
    public static final String WEDDING_HALL_EMAIL = "wedding-hall@lorem-ipsum.pl";

    public static final String[] PHOTOS_BS = {
            "https://images.unsplash.com/photo-1516975080664-ed2fc6a32937?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1531299244174-d247dd4e5a66?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=670&q=80",
            "https://images.unsplash.com/photo-1531895861208-8504b98fe814?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1552693673-1bf958298935?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80",
            "https://images.unsplash.com/photo-1526758097130-bab247274f58?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1575249142951-35b95b9bb5b7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1578609059782-d65297c61e69?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1552511556-9f16dcb6561f?ixlib=rb-1.2.1&auto=format&fit=crop&w=1052&q=80",
            "https://images.unsplash.com/photo-1575298591676-6c286e92b906?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1553540751-988bd7918c7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    };
    public static final String[] PHOTO_CARS = {
            "https://images.unsplash.com/photo-1430751254551-a927757e0bf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1053&q=80",
            "https://images.unsplash.com/photo-1516536900061-d881b27e8ff8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1523371696700-91e21249c0ed?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1464475355873-c68befb75ce9?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1434282781750-4a2b4b4617ce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1570907870057-e1e338bc0665?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80",
            "https://images.unsplash.com/photo-1542362567-b07e54358753?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1558173818-8863cc640a50?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1190&q=80",
            "https://images.unsplash.com/photo-1566899478234-cd963727a2ff?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1582467029665-d4b0775057de?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    };
    public static final String[] PHOTO_FS = {
            "https://images.unsplash.com/photo-1570189098678-0463301dafa7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=631&q=80",
            "https://images.unsplash.com/photo-1487070183336-b863922373d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1527609635833-38e4a5f7c941?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1560453497-fdcb351a0c55?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=629&q=80",
            "https://images.unsplash.com/photo-1525562764522-ab2eeb6bc6f6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80",
            "https://images.unsplash.com/photo-1417037129170-06a2750eaa47?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1494319988300-172cd182cb31?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1505990676835-b0c62d34782b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80",
            "https://images.unsplash.com/photo-1560597324-f8e931d1339d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=676&q=80",
            "https://images.unsplash.com/photo-1571535262391-5c08ca146103?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=925&q=80"
    };
    public static final String[] PHOTO_HD = {
            "https://images.unsplash.com/photo-1559599101-f09722fb4948?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1572872202671-dc8bd60080ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1481068164146-e8beb686f4d2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1581674210501-c760093514e8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1580421383874-7e60f05f64b4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1493775379751-a6c3940f3cbc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1549236177-ca2f08365400?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80",
            "https://images.unsplash.com/photo-1522337094846-8a818192de1f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=639&q=80",
            "https://images.unsplash.com/flagged/photo-1574819521733-32f8678f8179?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1572457391165-eaf92b4a7457?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    };
    public static final String[] PHOTO_MK = {
            "https://images.unsplash.com/photo-1487412947147-5cebf100ffc2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1051&q=80",
            "https://images.unsplash.com/photo-1530999651725-59e0e1761b3a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/flagged/photo-1577999499479-27ff8fbdb07d?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1531475925016-6d33cb7c8344?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1572786194701-34e2371239cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1578987463630-25ae2d364313?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1582576192532-06353147fcbf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1542460802-6166878e7035?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1579327529051-8ac5194313b6?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1523263685509-57c1d050d19b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80"
    };
    public static final String[] PHOTO_MB = {
            "https://images.unsplash.com/photo-1482575832494-771f74bf6857?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1512404871764-1cf03a297841?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1555644226-68851bd1e250?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1474692295473-66ba4d54e0d3?ixlib=rb-1.2.1&auto=format&fit=crop&w=976&q=80",
            "https://images.unsplash.com/photo-1532285105565-5860e4cb0e95?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1128&q=80",
            "https://images.unsplash.com/photo-1584208763071-c13d43773fce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1101&q=80",
            "https://images.unsplash.com/flagged/photo-1568174793785-c676866a312a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80",
            "https://images.unsplash.com/photo-1550634129-b71e31b56212?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60",
            "https://images.unsplash.com/photo-1563726527699-d6757e4bc42b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1545128485-c400e7702796?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    };
    public static final String[] PHOTO_WD = {
            "https://images.unsplash.com/photo-1557363763-8381968f8353?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/flagged/photo-1576786205629-05de8e46713d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1543290556-86c013a17574?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1549417229-7686ac5595fd?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1580151134699-e0cfbeb763d3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1502727135886-df285cc8379f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1490707967831-1fd9b48e40e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1517455850349-65b65b06f255?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1580824456021-1d205609fc19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1558979589-e1c8b4846d08?ixlib=rb-1.2.1&auto=format&fit=crop&w=632&q=80"
    };
    public static final String[] PHOTO_WH = {
            "https://images.unsplash.com/photo-1519167758481-83f550bb49b3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1074&q=80",
            "https://images.unsplash.com/photo-1583315149257-50502a28e29e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1560332218-4d266ab9793a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1048&q=80",
            "https://images.unsplash.com/photo-1549620936-aa6278062ba5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1525772764200-be829a350797?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1485178075098-49f78b4b43b4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1572319663329-ac47c4efdef0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1525258258500-a303891fcc61?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1560117530-10cc2f3bcbfc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1526092817387-8f07b2904e48?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    };
    public static final String[] PHOTO_WS = {
            "https://images.unsplash.com/photo-1529635229076-82fefed713c4?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1548454782-15b189d129ab?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1472417583565-62e7bdeda490?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1521341057461-6eb5f40b07ab?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1534030347209-467a5b0ad3e6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1558222218-b7b54eede3f3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1551853143-2a816dfebf84?ixlib=rb-1.2.1&auto=format&fit=crop&w=660&q=80",
            "https://images.unsplash.com/photo-1574781893996-39d93c298683?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1584940120743-8981ca35b012?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1508835277982-1c1b0e205603?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80"
    };
    public static final String[] PHOTO_PH = {
            "https://images.unsplash.com/photo-1552086231-dde3eb12cf60?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1475274226786-e636f48a5645?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1030&q=80",
            "https://images.unsplash.com/photo-1519741497674-611481863552?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1532712938310-34cb3982ef74?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1546032996-6dfacbacbf3f?ixlib=rb-1.2.1&auto=format&fit=crop&w=655&q=80",
            "https://images.unsplash.com/flagged/photo-1552981941-424aac2b4311?ixlib=rb-1.2.1&auto=format&fit=crop&w=677&q=80",
            "https://images.unsplash.com/photo-1556789456-02c1ffdf17ea?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1499417267106-45cebb7187c9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=661&q=80",
            "https://images.unsplash.com/photo-1578821604540-868cf2dc41c9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            "https://images.unsplash.com/photo-1580419707494-e6247bfeca71?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80"
    };
}

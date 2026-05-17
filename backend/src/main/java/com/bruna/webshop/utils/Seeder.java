    package com.bruna.webshop.utils;

    import com.bruna.webshop.controller.OrderController;
    import com.bruna.webshop.dao.*;
    import com.bruna.webshop.modules.*;
    import org.springframework.context.event.ContextRefreshedEvent;
    import org.springframework.context.event.EventListener;
    import org.springframework.stereotype.Component;

    import java.util.HashSet;
    import java.util.Set;

    @Component
    public class Seeder {
        private ProductRepository productRepository;
        private PublisherRepository publisherRepository;
        private WriterRepository writerRepository;
        private ReviewRepository reviewRepository;
        private UserDataRepository gebruikerGegevensRepository;
        private OrderRepository orderRepository;
        private OrderController orderController;
        private OrderItemRepository orderItemRepository;
        private GenreRepository genreRepository;
        private DifficultyRepository difficultyRepository;
        private RoleRepository roleRepository;

        public Seeder(ProductRepository productRepository, PublisherRepository publisherRepository, WriterRepository writerRepository, ReviewRepository reviewRepository, UserDataRepository gebruikerGegevensRepository, OrderRepository orderRepository, OrderController orderController, OrderItemRepository orderItemRepository, GenreRepository genreRepository, DifficultyRepository difficultyRepository, RoleRepository roleRepository) {
            this.productRepository = productRepository;
            this.publisherRepository = publisherRepository;
            this.writerRepository = writerRepository;
            this.reviewRepository = reviewRepository;
            this.gebruikerGegevensRepository = gebruikerGegevensRepository;
            this.orderRepository = orderRepository;
            this.orderController = orderController;
            this.orderItemRepository = orderItemRepository;
            this.genreRepository = genreRepository;
            this.difficultyRepository = difficultyRepository;
            this.roleRepository = roleRepository;
        }

        @EventListener
        public void seed(ContextRefreshedEvent event) {
            Role user = new Role(ERole.ROLE_USER);
            roleRepository.save(user);

            Role admin = new Role(ERole.ROLE_ADMIN);
            roleRepository.save(admin);

            //--

            Publisher kluitman = new Publisher("Kluitman","https://i.ibb.co/jvY0MjMX/apple-touch-icon.png");
            this.publisherRepository.save(kluitman);

            Publisher volt = new Publisher("Volt", "https://i.ibb.co/60f5QBy6/volt.png");
            this.publisherRepository.save(volt);

            Publisher hooglandKlaveren = new Publisher("Hoogland & Van Klaveren, Uitgeverij", "https://i.ibb.co/zVpb00Zs/logo-hvk-kl.png");
            this.publisherRepository.save(hooglandKlaveren);

            Publisher lemniscaat = new Publisher("lemniscaat", "https://i.ibb.co/fY5dNWBY/Lemniscaat-logo.png");
            this.publisherRepository.save(lemniscaat);

            Publisher blossomBooks = new Publisher("Blossom Books", "https://i.ibb.co/Qjp8RDwY/blossom.png");
            this.publisherRepository.save(blossomBooks);

            Publisher vanGoor = new Publisher("Van Goor", "https://i.ibb.co/SwW6CqsS/van-goor.png");
            this.publisherRepository.save(vanGoor);

            Publisher amboAnthos = new Publisher("Ambo|Anthos", "https://i.ibb.co/1JKBCJ9b/Amboanthos.png");
            this.publisherRepository.save(amboAnthos);

            Publisher querido = new Publisher("Querido", "https://i.ibb.co/JWbqs42H/Querido-Logo-300dpi-klein.png");
            this.publisherRepository.save(querido);

            Publisher pluim = new Publisher("Uitgeverij Pluim", "https://i.ibb.co/SwW6CqsS/van-goor.png");
            this.publisherRepository.save(pluim);

            Publisher dasMag = new Publisher("Das Mag Uitgeverij B.V.", "https://i.ibb.co/FbYz8XHD/das-mag.png");
            this.publisherRepository.save(dasMag);

            Publisher atlasContact = new Publisher("Atlas Contact", "https://i.ibb.co/S76k4wYq/Atlas-logo.png");
            this.publisherRepository.save(atlasContact);

            Publisher ploegsma = new Publisher("Ploegsma", "https://i.ibb.co/wbFJpWz/cropped-Favicon-Ploegsma.png");
            this.publisherRepository.save(ploegsma);

            Publisher condor = new Publisher("Condor", "https://i.ibb.co/b8LRJGY/condor-190-nl.jpg");
            this.publisherRepository.save(condor);

            Publisher eenvoudigCommuniceren = new Publisher("Uitgeverij Eenvoudig Communiceren B.V", "https://i.ibb.co/qF9bKPTp/eenvoudigcommuniceren.jpg");
            this.publisherRepository.save(eenvoudigCommuniceren);

            //----

            Writer marcelVanDriel = new Writer("Marcel", "van", "Driel");
            this.writerRepository.save(marcelVanDriel);

            Writer arndisThorarinsdottir = new Writer("Arndís", null, "Thórarinsdóttir");
            this.writerRepository.save(arndisThorarinsdottir);

            Writer sjoerdKuyper = new Writer("Sjoerd", null, "Kuyper");
            this.writerRepository.save(sjoerdKuyper);

            Writer annaVanPraag = new Writer("Anna", "van", "Praag");
            this.writerRepository.save(annaVanPraag);

            Writer jandyNelson = new Writer("Jandy", null, "Nelson");
            this.writerRepository.save(jandyNelson);

            Writer lucasVersteeg = new Writer("Lucas", null, "Versteeg");
            this.writerRepository.save(lucasVersteeg);

            Writer lexPaleaux = new Writer("Lex", null, "Paleaux");
            this.writerRepository.save(lexPaleaux);

            Writer joostOomen = new Writer("Joost", null, "Oomen");
            this.writerRepository.save(joostOomen);

            Writer sabrineIngabire = new Writer("Sabrine", null, "Ingabire");
            this.writerRepository.save(sabrineIngabire);

            Writer saskiaDeCoster = new Writer("Saskia", "de", "Coster");
            this.writerRepository.save(saskiaDeCoster);

            Writer marikenHeitman = new Writer("Mariken", null, "Heitman");
            this.writerRepository.save(marikenHeitman);

            Writer juttaNymphius = new Writer("Jutta", null, "Nymphius");
            this.writerRepository.save(juttaNymphius);

            Writer jowiSchmitz = new Writer("Jowi", null, "Schmitz");
            this.writerRepository.save(jowiSchmitz);

            Writer rainaTelgemeier = new Writer("Raina", null, "Telgemeier");
            this.writerRepository.save(rainaTelgemeier);

            Writer simoneArts = new Writer("Simone", null, "Arts");
            this.writerRepository.save(simoneArts);

            //----

            Genre yaThriller = new Genre("YA-thriller");
            Set<Genre> vierentwintigUurGenres = new HashSet<>();
            vierentwintigUurGenres.add(yaThriller);
            this.genreRepository.save(yaThriller);

            Genre probleemboek = new Genre("Probleemboek");
            Genre sportverhaal = new Genre("Sportverhaal");
            Set<Genre> saltoGenres = new HashSet<>();
            saltoGenres.add(probleemboek);
            saltoGenres.add(sportverhaal);
            this.genreRepository.save(probleemboek);
            this.genreRepository.save(sportverhaal);

            Genre avontuur = new Genre("Avontuur");
            Genre humor = new Genre("Humor");
            Genre toekomstverhalen = new Genre("Toekomstverhalen");
            Set<Genre> deGroteVloedGenres = new HashSet<>();
            deGroteVloedGenres.add(avontuur);
            deGroteVloedGenres.add(humor);
            deGroteVloedGenres.add(toekomstverhalen);
            this.genreRepository.save(avontuur);
            this.genreRepository.save(humor);
            this.genreRepository.save(toekomstverhalen);

            Genre jeugdroman = new Genre("Jeugdroman");
            Set<Genre> jonaGenres = new HashSet<>();
            jonaGenres.add(jeugdroman);
            this.genreRepository.save(jeugdroman);

            Genre youngAdultRoman = new Genre("Young adult");
            Genre magischRealisme = new Genre("Magisch realisme");
            Genre romantiek = new Genre("Romantiek");
            Set<Genre> alsDeWereldWankeltGenres = new HashSet<>();
            alsDeWereldWankeltGenres.add(youngAdultRoman);
            alsDeWereldWankeltGenres.add(magischRealisme);
            alsDeWereldWankeltGenres.add(romantiek);
            this.genreRepository.save(youngAdultRoman);
            this.genreRepository.save(magischRealisme);
            this.genreRepository.save(romantiek);

            Genre comingOfAge = new Genre("Coming-of-age");
            Genre lgbtq = new Genre("LGBTQ+");
            Set<Genre> frambozenzomerGenres = new HashSet<>();
            frambozenzomerGenres.add(youngAdultRoman);
            frambozenzomerGenres.add(comingOfAge);
            frambozenzomerGenres.add(lgbtq);
            this.genreRepository.save(comingOfAge);
            this.genreRepository.save(lgbtq);

            Genre literaireFictie = new Genre("Literaire fictiel");
            Set<Genre> liftenNaarDeHemelGenres = new HashSet<>();
            liftenNaarDeHemelGenres.add(comingOfAge);
            liftenNaarDeHemelGenres.add(literaireFictie);
            this.genreRepository.save(literaireFictie);

            Set<Genre> hetParadijsVanSlapenGenres = new HashSet<>();
            hetParadijsVanSlapenGenres.add(literaireFictie);

            Set<Genre> lotgenotenGenres = new HashSet<>();
            lotgenotenGenres.add(comingOfAge);
            lotgenotenGenres.add(literaireFictie);

            Genre familieroman = new Genre("Familieroman");
            Set<Genre> netEchtGenres = new HashSet<>();
            netEchtGenres.add(familieroman);
            netEchtGenres.add(literaireFictie);
            this.genreRepository.save(familieroman);

            Genre queerFictie = new Genre("Queer fictie");
            Genre genderstudies = new Genre("Genderstudies");
            Genre literatuurRoman = new Genre("Literatuur roman");
            Set<Genre> wormmaanGenres = new HashSet<>();
            wormmaanGenres.add(literatuurRoman);
            wormmaanGenres.add(genderstudies);
            wormmaanGenres.add(queerFictie);
            this.genreRepository.save(literatuurRoman);
            this.genreRepository.save(genderstudies);
            this.genreRepository.save(queerFictie);

            Genre schoolVerhaal = new Genre("Schoolverhaal");
            Set<Genre> blootGenres = new HashSet<>();
            blootGenres.add(schoolVerhaal);
            this.genreRepository.save(schoolVerhaal);

            Genre spanning = new Genre("Spanning");
            Set<Genre> slipjachtGenres = new HashSet<>();
            slipjachtGenres.add(avontuur);
            slipjachtGenres.add(spanning);
            this.genreRepository.save(spanning);

            Genre graphicNovel = new Genre("Graphic Novel");
            Genre youngAdult = new Genre("Young Adult");
            Set<Genre> smileGenres = new HashSet<>();
            smileGenres.add(graphicNovel);
            smileGenres.add(youngAdult);
            smileGenres.add(schoolVerhaal);
            this.genreRepository.save(graphicNovel);
            this.genreRepository.save(youngAdult);

            Genre realistischeFictie = new Genre("Realistische Fictie");
            Set<Genre> onderWaterGenres = new HashSet<>();
            onderWaterGenres.add(comingOfAge);
            onderWaterGenres.add(schoolVerhaal);
            onderWaterGenres.add(realistischeFictie);
            this.genreRepository.save(realistischeFictie);

            //----

            Difficulty difficultyStartO = new Difficulty("niveau start (12-15)");
            this.difficultyRepository.save(difficultyStartO);

            Difficulty difficultyEenO = new Difficulty("niveau 1 (12-15)");
            this.difficultyRepository.save(difficultyEenO);

            Difficulty difficultyTweeO = new Difficulty("niveau 2 (12-15)");
            this.difficultyRepository.save(difficultyTweeO);

            Difficulty difficultyDrieO = new Difficulty("niveau 3 (12-15)");
            this.difficultyRepository.save(difficultyDrieO);

            Difficulty difficultyVierO = new Difficulty("niveau 4 (12-15)");
            this.difficultyRepository.save(difficultyVierO);

            Difficulty difficultyEenB = new Difficulty("niveau 1 (15-18)");
            this.difficultyRepository.save(difficultyEenB);

            Difficulty difficultyTweeB = new Difficulty("niveau 2 (15-18)");
            this.difficultyRepository.save(difficultyTweeB);

            Difficulty difficultyDrieB = new Difficulty("niveau 3 (15-18)");
            this.difficultyRepository.save(difficultyDrieB);

            Difficulty difficultyVierB = new Difficulty("niveau 4 (15-18)");
            this.difficultyRepository.save(difficultyVierB);

            Difficulty difficultyVijfB = new Difficulty("niveau 5 (15-18)");
            this.difficultyRepository.save(difficultyVijfB);

            Difficulty difficultyZesB = new Difficulty("niveau 6 (15-18)");
            this.difficultyRepository.save(difficultyZesB);

            //----

            Product vierentwintigUur = new Product("24 uur", "eboek", 10.00, "De zestienjarige Claire werkt tijdens de kerstvakantie als flitsbezorger. " +
                    "Op het adres van haar laatste bestelling wordt ze opgewacht door twee gewapende broers. Deze jongens spelen graag een gevaarlijk spel: " +
                    "Claire moet zonder telefoon, jas en op blote voeten 24 uur uit handen van de jongens blijven. Ze mag niemand om hulp vragen en niet naar de " +
                    "politie stappen. Als dat lukt, wint ze 10.000 euro. Als het niet lukt, wordt ze vermoord. Claire heeft al snel door dat de broers hun eigen " +
                    "regels niet volgen. Ze kan alleen maar overleven als zij ook de regels van het spel verandert.",
                    "Nederlands", 105, marcelVanDriel, kluitman, null, 20, "https://i.ibb.co/fYyZqVZq/24uur.png", false, difficultyStartO);
            vierentwintigUur.setGenreList(vierentwintigUurGenres);
            this.productRepository.save(vierentwintigUur);

            Product salto = new Product("Salto", "boek", 15.99, "Álfur (12) wil net zo goed worden in turnen als zijn tante Harpa, " +
                    "die naar de Olympische Spelen is geweest. Maar door zijn thuissituatie kan hij zich niet goed op het turnen concentreren. " +
                    "Zijn ouders denken namelijk dat Álfurs broertje Eiki autisme heeft en dat ze hem helpen door voortaan glutenvrij te eten en misschien zelfs te verhuizen. " +
                    "Álfur vindt het een belachelijke gedachte dat Eiki autisme zou hebben en wil bewijzen dat er niets met hem aan de hand is. " +
                    "En als het hem lukt zijn ouders te overtuigen, hoeft er ook niets te veranderen in hun leven.",
                    "Nederlands", 291, arndisThorarinsdottir, volt, "hardcover", 22, "https://i.ibb.co/VY0V7qrW/salto.png", false, difficultyEenO);
            salto.setGenreList(saltoGenres);
            this.productRepository.save(salto);

            Product deGroteVloed = new Product("De grote vloed", "boek", 10.15, "Het is 2029: het jaar van ‘de grote vloed’. Nederland en de rest van de wereld staan onder water. " +
                    "Gelukkig heeft Moos (14) een vlot gebouwd, waarop hij nu samen met zijn opa Leon in diens oude auto bivakkeert." +
                    " Wat volgt is een spannend en bizar avontuur, waarin ze samen met de professor en de burgemeester op zoek gaan naar de berg Atlantis. " +
                    "Maar op dit enige nog droog gelegen stuk land zijn ‘vloedvluchtelingen’ allesbehalve welkom…",
                    "Nederlands", 187, sjoerdKuyper, hooglandKlaveren, "paperback", 15, "https://i.ibb.co/sp7vmV4F/degrotevloed.png", false, difficultyTweeO);
            deGroteVloed.setGenreList(deGroteVloedGenres);
            this.productRepository.save(deGroteVloed);

            Product jona = new Product("Jona", "eboek", 9.95, "Het leven van de zestienjarige Jona komt op zijn kop te staan wanneer hij met zijn profielwerkstuk aan de slag gaat. " +
                    "Samen met twee klasgenoten duikt hij in het verleden van zijn oma. Zij heeft beginnende alzheimer en begint steeds over ene Simon, " +
                    "terwijl Jona nog nooit van een Simon heeft gehoord. Jona’s vader is heel streng en vindt het maar niks dat Jona zijn oma interviewt. " +
                    "Hij vindt dat je het verleden moet laten rusten en eist dat Jona stopt met het project. Waarom mag Jona geen herinneringen ophalen met zijn oma? Welke zaken moeten verborgen blijven?", "Nederlands", 263, annaVanPraag, lemniscaat,
                    null, 17, "https://i.ibb.co/XrwwSRPs/jona.png",
                    false, difficultyDrieO);
            jona.setGenreList(jonaGenres);
            this.productRepository.save(jona);

            Product alsDeWereldWankelt = new Product("Als de wereld wankelt", "boek", 19.99, "De familie Fall woont in een vallei in Californië, waar geheimen, magie en oude familieverhalen zich met elkaar verweven. " +
                    "Nadat hun vader op mysterieuze wijze verdwijnt, probeert elk gezinslid dit op zijn eigen manier te verwerken. " +
                    "Dizzy (12) ziet geesten, Miles (17) is op zoek naar zichzelf en Wynton (19) balanceert tussen roem en zelfvernietiging. Wanneer een raadselachtig meisje met regenbooghaar hun leven binnenwandelt, verandert alles. " +
                    "Ze lijkt een belangrijke rol te spelen in het leven van Dizzy, Miles en Wynton. Brengt ze de familie bij elkaar of maakt ze alles alleen maar erger?",
                    "Nederlands", 551, jandyNelson, blossomBooks, "paperback", 17, "https://i.ibb.co/v4gPgKvq/wereldwankelt.png", false, difficultyVierO);
            alsDeWereldWankelt.setGenreList(alsDeWereldWankeltGenres);
            this.productRepository.save(alsDeWereldWankelt);

            Product frambozenzomer = new Product("Frambozenzomer", "eboek", 29.99, "De creatieve Thomas (16) verheugt zich op het teken- en schilderkamp waar hij in de zomervakantie heen zal gaan. " +
                    "Maar zijn ouders blijken een ander plan te hebben. Zonder overleg hebben zij hem aangemeld voor een zomerkamp waar jongeren leren gezonder te leven. " +
                    "Thomas heeft altijd al problemen gehad met zijn gewicht en is hier erg onzeker over. " +
                    "Op het kamp ontmoet hij Fender (17), die daar de leiding helpt. Fender is alles wat Thomas ooit hoopt te zijn: slank, zelfverzekerd en … uit de kast.",
                    "Nederlands", 285, lucasVersteeg, vanGoor, null, 3, "https://i.ibb.co/ymj5RG6p/frambozenzomer.png",
                    false, difficultyEenB);
            frambozenzomer.setGenreList(frambozenzomerGenres);
            this.productRepository.save(frambozenzomer);

            Product liftenNaarDeHemel = new Product("Liften naar de hemel", "eboek", 17.89, "Quintin (16) is net ontslagen uit een jeugdinrichting als hij weer de verkeerde afslag neemt. " +
                    "Zijn streng gereformeerde ouders weten niet meer wat ze met hem aan moeten en sturen hem naar een pleeggezin in Canada. " +
                    "Quintin is serieus gemotiveerd om in een andere omgeving een nieuwe start te maken; hij is vast van plan het beste uit zichzelf te halen. " +
                    "De Canadese pleegouders Decker willen hem vooral heropvoeden en hem laten buigen voor hun strenge huisregels. ‘Jij gaat weer een kind van God worden, dat is mijn taak. Heb jij mij begrepen?’", "Nederlands",
                    306, lexPaleaux, amboAnthos, null, 5, "https://i.ibb.co/TqrWWfyL/liftennaardehemel.png",
                    false, difficultyTweeB);
            liftenNaarDeHemel.setGenreList(liftenNaarDeHemelGenres);
            this.productRepository.save(liftenNaarDeHemel);

            Product hetParadijsVanSlapen = new Product("Het paradijs van slapen", "boek", 17.98, "Gerrit Blauw is 71, gezond van geest, fit van lijf en leden. Toch heeft hij een doodswens. " +
                    "Hij heeft van het leven genoten, vooral van de schoonheid die hij heeft ervaren, als dichter, als theatermaker, als mens. Hij wil ook ‘in schoonheid’ afscheid van het leven nemen, " +
                    "voordat de onvermijdelijke aftakeling inzet. Daartoe roept hij de hulp in van dokter Engel, een arts die euthanasie verleent aan doodzieke mensen die ‘ondraaglijk en uitzichtloos lijden’.",
                    "Nederlands", 205, joostOomen, querido, "hardcover", 16, "https://i.ibb.co/TMC2hnmw/hetparadijsvanslapen.png",
                    false, difficultyDrieB);
            hetParadijsVanSlapen.setGenreList(hetParadijsVanSlapenGenres);
            this.productRepository.save(hetParadijsVanSlapen);

            Product lotgenoten = new Product("Lotgenoten", "boek", 24.99, "'In hun aanwezigheid werd me altijd duidelijk hoe erg mijn persoonlijkheid gebaseerd was op anderen: hoe erg ik bezig was met NIET ZOALS ZIJ te zijn, " +
                    "hoe erg ik bezig was met BIJ HEN te horen. " +
                    "Wie was ik in groepen met andere Zwarte meisjes? Als ik niet meer de enige Zwarte persoon in de kamer was en daardoor de facto interessant was - wat bleef er dan over?'", "Nederlands", 189, sabrineIngabire, pluim, "paperback", 18,
                    "https://i.ibb.co/tTKxzwxD/lotgenoten.png", true, difficultyVierB);
            lotgenoten.setGenreList(lotgenotenGenres);
            this.productRepository.save(lotgenoten);

            Product netEcht = new Product("Net Echt", "eboek", 12.99, "Je staat voor een statig herenhuis in de Blauwstraat (Antwerpen). Je kunt elk moment de sleutel omdraaien en het huis betreden. Waar kom je terecht? In het huis van Max, " +
                    "Manon en hun dochter Noah, of in het hoofd van de verteller? " +
                    "Twee verhalen schuiven raadselachtig over elkaar heen, alsof de verteller zijn eigen geschiedenis heeft verstopt in het huis in de Blauwstraat, in het verhaal van Max, Manon en Noah.", "Nederlands", 280, saskiaDeCoster, dasMag,
                    null, 37, "https://i.ibb.co/21c2M10Y/netecht.png", true, difficultyVijfB);
            netEcht.setGenreList(netEchtGenres);
            this.productRepository.save(netEcht);

            Product wormmaan = new Product("Wormmaan", "boek", 16.15, "Elke wil een nieuw pompoenras lanceren, maar de concurrent is haar net voor. Jarenlang veredelen blijkt voor niets te zijn geweest. " +
                    "Als dan een collega ook nog een negatieve opmerking maakt over genderdiversiteit, terwijl hij weet dat zij niet zo’n typische ‘vrouw’ is, neemt ze ontslag. " +
                    "Ze vertrekt met een vergeten erwtenras naar het huis van haar overleden oom, op een van de Waddeneilanden, juist om deze erwt te laten verwilderen. Daar worstelt ze met de vrouw die zij nooit geworden is.", "Nederlands",
                    224, marikenHeitman, atlasContact, "hardcover", 14, "https://i.ibb.co/R4JCBCGw/wormmaan.png",
                    false, difficultyZesB);
            wormmaan.setGenreList(wormmaanGenres);
            this.productRepository.save(wormmaan);

            Product bloot = new Product("Bloot", "boek", 18.45, "Amelie (13) is niet tevreden over haar uiterlijk. Ze zoekt naar kledingtips om haar piramidefiguur te verbergen en ze fotoshopt haar eigen gezicht op perfecte lichamen. " +
                    "Ook maakt Amelie zich druk over haar vrienden en liefdesleven. Ze krijgt meer zelfvertrouwen als ze bevriend raakt met Kira. Zij kent de knappe Elias en brengt Amelie met hem in contact. " +
                    "Maar wat moet Amelie doen als Elias vraagt of ze hem een foto van haar borsten wil sturen?", "Nederlands", 192, juttaNymphius, ploegsma, "paperback", 17, "https://i.ibb.co/7xQy0Phs/bloot.jpg", false, difficultyStartO);
            bloot.setGenreList(blootGenres);
            this.productRepository.save(bloot);

            Product slipjacht = new Product("Slipjacht", "eboek", 9.99, "Mateo is op school een buitenbeetje en wil niet mee op schoolkamp naar de Veluwe. Als zijn vader zijn bloederige tekeningen vindt, " +
                    "wil hij Mateo naar een therapeut sturen. Dat wil Mateo niet en daarom besluit hij toch eerst op kamp te gaan. Hij wil namelijk verdwijnen op de Veluwe. " +
                    "Tijdens zijn eerste nacht vindt hij een klein vosje waarmee hij vrienden wordt. " +
                    "Samen proberen ze iedereen te slim af te zijn: Mateo’s vader, zijn klasgenoten en de jagers in het bos. Dat lukt, maar het lijkt alsof er nóg iemand jaagt op Mateo en het vosje. Kunnen ze die ook te slim af zijn?",
                    "Nederlands", 112, jowiSchmitz, kluitman, null, 9, "https://i.ibb.co/JWLf7G0x/slipjacht.jpg", true, difficultyStartO);
            slipjacht.setGenreList(slipjachtGenres);
            this.productRepository.save(slipjacht);

            Product smile = new Product("Smile", "eboek", 9.99, "Smile is een graphic novel over Raina, die door een stom ongelukje twee voortanden verliest. Het is het begin van een hele reeks tandartsbezoeken, operaties en verschillende beugels - " +
                    "soms zelfs met neptanden er aan. Raina wil op school niet opvallen en maakt zich door haar gebit extra druk over wat haar vriendinnen van haar zullen denken. En zal die leuke jongen haar ooit zien staan?", "Nederlands",
                    218, rainaTelgemeier, condor, null, 10, "https://i.ibb.co/zTwg39Nr/Smile.jpg", false, difficultyStartO);
            smile.setGenreList(smileGenres);
            this.productRepository.save(smile);

            Product onderWater = new Product("Onder water", "eboek", 9.99, "Joske heeft het niet makkelijk. Op school wordt ze gepest. En haar ouders zijn altijd aan het werk op de kaasboerderij. " +
                    "Alleen als ze zwemt, vergeet Joske haar zorgen. Dan denkt ze aan de enige op school die ze aardig vindt en vertrouwt: Fouad. Fouad met zijn lange wimpers en zijn leuke lach...", "Nederlands", 91,
                    simoneArts, eenvoudigCommuniceren, null, 29, "https://i.ibb.co/PZScGQfd/onderwater.jpg", true, difficultyStartO);
            onderWater.setGenreList(onderWaterGenres);
            this.productRepository.save(onderWater);
        }
    }

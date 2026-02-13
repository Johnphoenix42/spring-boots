package com.yetunde.blog;

import com.yetunde.blog.model.Post;
import com.yetunde.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public CommandLineRunner initPosts(PostRepository postRepository) {
		String post1 = "<article>\n" +
				"  <h2>The Renaissance of Aso Oke: Modernizing Nigerian Tradition</h2>\n" +
				"\n" +
				"  <p>\n" +
				"    In the vibrant streets of Lagos and the high-fashion runways of Abuja, a quiet revolution is taking place. <strong>Aso Oke</strong>, the hand-woven cloth synonymous with Yoruba heritage, is no longer reserved solely for traditional weddings or milestone celebrations. Nigeria’s contemporary designers are reimagining this storied textile for the 21st-century wardrobe.\n" +
				"  </p>\n" +
				"\n" +
				"  <p>\n" +
				"    By blending structured weaving techniques with <strong>modern silhouettes</strong>—think sleek power blazers, avant-garde corsets, and even streetwear-inspired vests—the industry is proving that \"traditional\" doesn't mean \"static.\" This movement isn't just about aesthetics; it’s a masterclass in <strong>sustainable luxury</strong>.\n" +
				"  </p>\n" +
				"\n" +
				"  <blockquote>\n" +
				"    \"Our fashion is our history written in thread. By modernizing Aso Oke, we aren't just wearing clothes; we’re carrying our ancestors' craftsmanship into the future.\"\n" +
				"  </blockquote>\n" +
				"\n" +
				"  <p>\n" +
				"    As Nigerian fashion continues to dominate the global stage, the message is clear: the future of style is deeply rooted in home-grown authenticity. Whether it’s paired with denim or styled as a full monochromatic look, Aso Oke remains the heartbeat of <strong>Naija Chic</strong>.\n" +
				"  </p>\n" +
				"</article>";

		String post2 = "<article>\n" +
				"  <h2>Street Style Stars: How Lagos Fashion is Redefining Global Trends</h2>\n" +
				"\n" +
				"  <p>\n" +
				"    Lagos isn't just a city; it's a runway. From the bustling markets of Balogun to the chic galleries of Victoria Island, Nigerian street style is a vibrant, unapologetic declaration of individuality and cultural pride. Forget fleeting trends dictated by Parisian or Milanese catwalks; in Lagos, fashion is an organic, electrifying conversation.\n" +
				"  </p>\n" +
				"\n" +
				"  <p>\n" +
				"    What makes Lagos street style so captivating? It’s the fearless embrace of color, the ingenious mix of traditional prints with contemporary cuts, and the undeniable swagger with which every outfit is worn. You’ll see handcrafted Adire fabrics transformed into structured jackets, vibrant Ankara prints tailored into sharp suits, and an abundance of statement accessories that tell a story.\n" +
				"  </p>\n" +
				"\n" +
				"  <blockquote>\n" +
				"    \"Lagos fashion isn't about following rules; it's about making them. It's a symphony of heritage and rebellion, all in one stunning look.\"\n" +
				"  </blockquote>\n" +
				"\n" +
				"  <p>\n" +
				"    This isn't just about looking good; it's about confidence, creativity, and a deep connection to identity. As global fashion increasingly looks towards Africa for inspiration, Lagos street style continues to lead the charge, proving that true innovation begins on the pavement.\n" +
				"  </p>\n" +
				"</article>";
		return (args) -> {
			postRepository.save(new Post("The Renaissance of Aso Oke: Modernizing Nigerian Tradition", post1,
					"This is the post summary", "Fashion", "Yetunde", "/images/post1.png", LocalDateTime.now()));
			postRepository.save(new Post("How fashion ripples across Our socio-cultural lives", post2,
					"This is the post summary", "Fashion", "Yetunde", "/images/post2.png", LocalDateTime.now()));
			for (Post post: postRepository.findAll()) {
				System.out.println(post.getId());
			}
		};
	}

}

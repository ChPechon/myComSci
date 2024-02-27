#version 330

in vec4 vCol;
out vec4 colour;
in vec2 TexCoord;

uniform vec3 lightColour;
uniform sampler2D texture2D;

void main()
{
    colour = texture(texture2D, TexCoord) * vec4(lightColour, 1.0);
}